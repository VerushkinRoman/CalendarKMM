package domain

import io.ktor.client.plugins.ServerResponseException
import io.ktor.utils.io.errors.IOException
import model.UiText
import resources.MR
import kotlin.coroutines.cancellation.CancellationException

sealed class Resource<T>(val data: T? = null, val error: ErrorType? = null) {
    class Success<T>(data: T? = null, error: ErrorType? = null) : Resource<T>(data, error)
    class Error<T>(error: ErrorType? = standardError) : Resource<T>(error = error)

    sealed class ErrorType(val message: UiText) {
        class Network(message: UiText) : ErrorType(message)
        class Other(message: UiText) : ErrorType(message)
    }

    companion object {
        val standardErrorMessage = UiText.StringResourceText(MR.strings.something_went_wrong)
        val standardError = ErrorType.Other(standardErrorMessage)
        private val networkErrorMessage = UiText.StringResourceText(MR.strings.network_error)
        private val serverErrorMessage = UiText.StringResourceText(MR.strings.server_error)

        suspend fun <T> handleResponse(data: suspend () -> T): Resource<T> {
            return try {
                Success(data())
            } catch (e: IOException) {
                Error(ErrorType.Network(networkErrorMessage))
            } catch (e: ServerResponseException) {
                if (e.response.status.value == 502) {
                    Error(ErrorType.Other(serverErrorMessage))
                } else {
                    val message = e.response.status.description.let { it.ifEmpty { null } }
                    Error(ErrorType.Other(getErrorMessage(message)))
                }
            } catch (e: Exception) {
                if (e is CancellationException) throw e
                else {
                    val message = e.message
                    Error(ErrorType.Other(getErrorMessage(message)))
                }
            }
        }

        private fun getErrorMessage(text: String?): UiText {
            return text?.let { UiText.RawString(it) } ?: standardErrorMessage
        }
    }
}
