package model

import platform.PlatformConfiguration

actual class GoogleAccount actual constructor(platformConfiguration: PlatformConfiguration) {
    actual fun getEmail(): String? = null
}