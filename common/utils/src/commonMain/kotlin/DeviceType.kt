import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

enum class DeviceType {
    Phone, // 0-600, 600-840
    Tablet // 840 +
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
val deviceType: DeviceType
    @Composable get() {
        val windowSizeClass = calculateWindowSizeClass()
        return when {
            windowSizeClass.widthSizeClass == WindowWidthSizeClass.Expanded
                    && (windowSizeClass.heightSizeClass == WindowHeightSizeClass.Expanded
                    || windowSizeClass.heightSizeClass == WindowHeightSizeClass.Medium) -> DeviceType.Tablet

            else -> DeviceType.Phone
        }
    }