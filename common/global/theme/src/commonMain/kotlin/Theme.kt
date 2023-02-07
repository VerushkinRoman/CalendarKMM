package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightThemeColors
    } else {
        DarkThemeColors
    }

    CompositionLocalProvider(
        LocalColorProvider provides colors,
        LocalTypographyProvider provides AppTypography,
        content = content
    )
}

object MaterialTheme {
    val colorScheme: AppColors
        @Composable
        get() = LocalColorProvider.current

    val typography: Typography
        @Composable
        get() = LocalTypographyProvider.current
}