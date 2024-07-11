import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    StatusBarColor(useDarkTheme)

    CompositionLocalProvider(
        LocalColorProvider provides ThemeColors,
        LocalTypographyProvider provides AppTypography,
        content = content
    )
}

object CalendarTheme {
    val colorScheme: AppColors
        @Composable
        get() = LocalColorProvider.current

    val typography: Typography
        @Composable
        get() = LocalTypographyProvider.current
}

@Composable
expect fun StatusBarColor(useDarkColors: Boolean = isSystemInDarkTheme())