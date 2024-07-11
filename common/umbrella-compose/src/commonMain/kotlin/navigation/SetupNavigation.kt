package navigation

import AppTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SetupNavigation(navigation: @Composable () -> Unit) {
    AppTheme(
        useDarkTheme = false
    ) {
        Surface(
            color = CalendarTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize(),
            content = navigation
        )
    }
}