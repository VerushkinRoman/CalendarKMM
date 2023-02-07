import com.russhwolf.settings.Settings
import platform.PlatformConfiguration

expect class Settings(platformConfiguration: PlatformConfiguration) {
    val settings: Settings
}