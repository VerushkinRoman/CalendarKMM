package domain

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.desc
import dev.icerock.moko.resources.format
import platform.PlatformConfiguration

actual class StringProvider actual constructor(platformConfiguration: PlatformConfiguration) {
    actual fun getString(stringResource: StringResource, args: List<Any>?): String =
        if (args != null) stringResource.format(args).localized()
        else stringResource.desc().localized()
}