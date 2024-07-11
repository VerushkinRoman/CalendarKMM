package domain

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.desc
import dev.icerock.moko.resources.format
import platform.PlatformConfiguration

actual class StringProvider actual constructor(private val platformConfiguration: PlatformConfiguration) {
    actual fun getString(stringResource: StringResource, args: List<Any>?): String =
        if (args == null) stringResource.desc().toString(platformConfiguration.androidContext)
        else stringResource.format(args).toString(platformConfiguration.androidContext)
}