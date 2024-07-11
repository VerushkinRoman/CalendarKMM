package model

import ComposeImmutable
import dev.icerock.moko.resources.StringResource
import di.Inject
import domain.ContainsStringResource
import domain.StringProvider

@ComposeImmutable
sealed class UiText {
    data class RawString(val value: String) : UiText()

    class StringResourceText(
        override val stringResource: StringResource,
        vararg val args: Any,
    ) : ContainsStringResource, UiText()

    fun getString(): String = when (this) {
        is RawString -> value
        is StringResourceText -> stringProvider.getString(
            stringResource = stringResource,
            args = args.map { it.toString() },
        )
    }

    companion object {
        private val stringProvider = StringProvider(Inject.instance())
    }
}