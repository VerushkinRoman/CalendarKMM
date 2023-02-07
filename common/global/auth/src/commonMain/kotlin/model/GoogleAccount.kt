package model

import platform.PlatformConfiguration

expect class GoogleAccount(platformConfiguration: PlatformConfiguration) {
    fun getEmail(): String?
}