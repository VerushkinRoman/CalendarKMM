import com.russhwolf.settings.Settings
import platform.PlatformConfiguration

actual class Settings actual constructor(platformConfiguration: PlatformConfiguration) {
    actual val settings: Settings = Settings()
}