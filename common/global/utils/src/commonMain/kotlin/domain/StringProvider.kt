package domain

import dev.icerock.moko.resources.StringResource
import platform.PlatformConfiguration

expect class StringProvider(platformConfiguration: PlatformConfiguration) {
    fun getString(stringResource: StringResource, args: List<Any>? = null): String
}