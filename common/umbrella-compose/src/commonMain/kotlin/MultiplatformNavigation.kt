import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import navigation.Navigation
import navigation.SetupNavigation
import utils.DeviceTypeProvider
import utils.LocalScreenSize
import utils.screenSizeInfo

@Composable
fun MultiplatformNavigation() {
    StatusBarColor(useDarkColors = true)
    CompositionLocalProvider(
        DeviceTypeProvider provides deviceType,
        LocalScreenSize provides screenSizeInfo,
    ) {
        SetupNavigation { Navigation() }
    }
}