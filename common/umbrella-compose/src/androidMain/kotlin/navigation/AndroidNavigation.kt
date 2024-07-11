package navigation

import MultiplatformNavigation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

fun ComponentActivity.setupThemedNavigation() {
    setContent {
        MultiplatformNavigation()
    }
}