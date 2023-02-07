import dev.icerock.moko.resources.desc.Raw
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import io.ktor.client.plugins.ServerResponseException
import io.ktor.utils.io.errors.IOException
import kotlin.coroutines.cancellation.CancellationException
import resources.MR

sealed class Resource<T>(val data: T? = null, val error: ErrorType? = null) {
    class Success<T>(data: T, error: ErrorType? = null) : Resource<T>(data, error)
    class Error<T>(error: ErrorType = standardError) : Resource<T>(error = error)
    class Loading<T>(data: T? = null) : Resource<T>(data)

    sealed class ErrorType(val message: StringDesc) {
        class Network(message: StringDesc) : ErrorType(message)
        class Other(message: StringDesc) : ErrorType(message)
    }

    companion object {
        val standardErrorMessage = MR.strings.something_went_wrong.desc()
        val standardError = ErrorType.Other(standardErrorMessage)
        private val networkErrorMessage = MR.strings.network_error.desc()
        private val serverErrorMessage = MR.strings.server_error.desc()

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

        private fun getErrorMessage(text: String?): StringDesc {
            return text?.let { StringDesc.Raw(it) } ?: standardErrorMessage
        }
    }
}
