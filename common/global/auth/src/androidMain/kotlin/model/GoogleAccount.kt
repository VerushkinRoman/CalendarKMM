package model

import com.google.android.gms.auth.api.signin.GoogleSignIn
import platform.PlatformConfiguration

actual class GoogleAccount actual constructor(private val platformConfiguration: PlatformConfiguration) {
    actual fun getEmail(): String? =
        GoogleSignIn.getLastSignedInAccount(platformConfiguration.androidContext)?.email
}