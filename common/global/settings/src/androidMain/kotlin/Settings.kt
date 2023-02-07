import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import platform.PlatformConfiguration

actual class Settings actual constructor(platformConfiguration: PlatformConfiguration) {
    private val delegate = platformConfiguration
        .androidContext
        .getSharedPreferences("Calendar", Context.MODE_PRIVATE)

    actual val settings: Settings = SharedPreferencesSettings(delegate)
}