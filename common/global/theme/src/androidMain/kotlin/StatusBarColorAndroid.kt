import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun StatusBarColor(useDarkColors: Boolean) {
    val context = LocalContext.current

    LaunchedEffect(true) {
        val barStyle = if (useDarkColors) {
            SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT,
            )
        } else {
            SystemBarStyle.light(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
            )
        }

        context.getActivity()?.enableEdgeToEdge(
            statusBarStyle = barStyle,
            navigationBarStyle = barStyle,
        )
    }
}

private fun Context.getActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}
//
///**
// * The default light scrim, as defined by androidx and the platform:
// * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=35-38;drc=27e7d52e8604a080133e8b842db10c89b4482598
// */
//private val lightScrim = android.graphics.Color.argb(0xe6, 0xFF, 0xFF, 0xFF)
//
///**
// * The default dark scrim, as defined by androidx and the platform:
// * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:activity/activity/src/main/java/androidx/activity/EdgeToEdge.kt;l=40-44;drc=27e7d52e8604a080133e8b842db10c89b4482598
// */
//private val darkScrim = android.graphics.Color.argb(0x80, 0x1b, 0x1b, 0x1b)