package theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import resources.MR

data class AppColors(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val tertiary: Color,
    val onTertiary: Color,
    val tertiaryContainer: Color,
    val onTertiaryContainer: Color,
    val error: Color,
    val errorContainer: Color,
    val onError: Color,
    val onErrorContainer: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color,
    val onSurfaceVariant: Color,
    val outline: Color,
    val inverseOnSurface: Color,
    val inverseSurface: Color,
    val inversePrimary: Color,
    val shadow: Color,
    val surfaceTint: Color
)

internal val LightThemeColors = AppColors(
    primary = Color(MR.colors.primary.light.argb),
    onPrimary = Color(MR.colors.onPrimary.light.argb),
    primaryContainer = Color(MR.colors.primaryContainer.light.argb),
    onPrimaryContainer = Color(MR.colors.onPrimaryContainer.light.argb),
    secondary = Color(MR.colors.secondary.light.argb),
    onSecondary = Color(MR.colors.onSecondary.light.argb),
    secondaryContainer = Color(MR.colors.secondaryContainer.light.argb),
    onSecondaryContainer = Color(MR.colors.onSecondaryContainer.light.argb),
    tertiary = Color(MR.colors.tertiary.light.argb),
    onTertiary = Color(MR.colors.onTertiary.light.argb),
    tertiaryContainer = Color(MR.colors.tertiaryContainer.light.argb),
    onTertiaryContainer = Color(MR.colors.onTertiaryContainer.light.argb),
    error = Color(MR.colors.error.light.argb),
    errorContainer = Color(MR.colors.errorContainer.light.argb),
    onError = Color(MR.colors.onError.light.argb),
    onErrorContainer = Color(MR.colors.onErrorContainer.light.argb),
    background = Color(MR.colors.background.light.argb),
    onBackground = Color(MR.colors.onBackground.light.argb),
    surface = Color(MR.colors.surface.light.argb),
    onSurface = Color(MR.colors.onSurface.light.argb),
    surfaceVariant = Color(MR.colors.surfaceVariant.light.argb),
    onSurfaceVariant = Color(MR.colors.onSurfaceVariant.light.argb),
    outline = Color(MR.colors.outline.light.argb),
    inverseOnSurface = Color(MR.colors.inverseOnSurface.light.argb),
    inverseSurface = Color(MR.colors.inverseSurface.light.argb),
    inversePrimary = Color(MR.colors.inversePrimary.light.argb),
    shadow = Color(MR.colors.shadow.light.argb),
    surfaceTint = Color(MR.colors.surfaceTint.light.argb)
)

internal val DarkThemeColors = AppColors(
    primary = Color(MR.colors.primary.dark.argb),
    onPrimary = Color(MR.colors.onPrimary.dark.argb),
    primaryContainer = Color(MR.colors.primaryContainer.dark.argb),
    onPrimaryContainer = Color(MR.colors.onPrimaryContainer.dark.argb),
    secondary = Color(MR.colors.secondary.dark.argb),
    onSecondary = Color(MR.colors.onSecondary.dark.argb),
    secondaryContainer = Color(MR.colors.secondaryContainer.dark.argb),
    onSecondaryContainer = Color(MR.colors.onSecondaryContainer.dark.argb),
    tertiary = Color(MR.colors.tertiary.dark.argb),
    onTertiary = Color(MR.colors.onTertiary.dark.argb),
    tertiaryContainer = Color(MR.colors.tertiaryContainer.dark.argb),
    onTertiaryContainer = Color(MR.colors.onTertiaryContainer.dark.argb),
    error = Color(MR.colors.error.dark.argb),
    errorContainer = Color(MR.colors.errorContainer.dark.argb),
    onError = Color(MR.colors.onError.dark.argb),
    onErrorContainer = Color(MR.colors.onErrorContainer.dark.argb),
    background = Color(MR.colors.background.dark.argb),
    onBackground = Color(MR.colors.onBackground.dark.argb),
    surface = Color(MR.colors.surface.dark.argb),
    onSurface = Color(MR.colors.onSurface.dark.argb),
    surfaceVariant = Color(MR.colors.surfaceVariant.dark.argb),
    onSurfaceVariant = Color(MR.colors.onSurfaceVariant.dark.argb),
    outline = Color(MR.colors.outline.dark.argb),
    inverseOnSurface = Color(MR.colors.inverseOnSurface.dark.argb),
    inverseSurface = Color(MR.colors.inverseSurface.dark.argb),
    inversePrimary = Color(MR.colors.inversePrimary.dark.argb),
    shadow = Color(MR.colors.shadow.dark.argb),
    surfaceTint = Color(MR.colors.surfaceTint.dark.argb)
)

internal val LocalColorProvider =
    staticCompositionLocalOf<AppColors> { error("no default implementation") }