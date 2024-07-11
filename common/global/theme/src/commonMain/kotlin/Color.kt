import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.compose.colorResource
import resources.MR

data class AppColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val error: Color,
    val onError: Color,
    val background: Color,
    val onBackground: Color,
    val shadow: Color,
    val textField: Color,
    val onTextField: Color,
)

internal val ThemeColors: AppColors
    @Composable get() = AppColors(
        primary = colorResource(MR.colors.primary),
        onPrimary = colorResource(MR.colors.onPrimary),
//        primaryContainer = colorResource(MR.colors.primaryContainer),
//        onPrimaryContainer = colorResource(MR.colors.onPrimaryContainer),
        secondary = colorResource(MR.colors.secondary),
        onSecondary = colorResource(MR.colors.onSecondary),
//        secondaryContainer = colorResource(MR.colors.secondaryContainer),
//        onSecondaryContainer = colorResource(MR.colors.onSecondaryContainer),
//        tertiary = colorResource(MR.colors.tertiary),
//        onTertiary = colorResource(MR.colors.onTertiary),
//        tertiaryContainer = colorResource(MR.colors.tertiaryContainer),
//        onTertiaryContainer = colorResource(MR.colors.onTertiaryContainer),
        error = colorResource(MR.colors.error),
//        errorContainer = colorResource(MR.colors.errorContainer),
        onError = colorResource(MR.colors.onError),
//        onErrorContainer = colorResource(MR.colors.onErrorContainer),
        background = colorResource(MR.colors.background),
        onBackground = colorResource(MR.colors.onBackground),
//        surface = colorResource(MR.colors.surface),
//        onSurface = colorResource(MR.colors.onSurface),
//        surfaceVariant = colorResource(MR.colors.surfaceVariant),
//        onSurfaceVariant = colorResource(MR.colors.onSurfaceVariant),
//        outline = colorResource(MR.colors.outline),
//        inverseOnSurface = colorResource(MR.colors.inverseOnSurface),
//        inverseSurface = colorResource(MR.colors.inverseSurface),
//        inversePrimary = colorResource(MR.colors.inversePrimary),
        shadow = colorResource(MR.colors.shadow),
//        surfaceTint = colorResource(MR.colors.surfaceTint)
        textField = colorResource(MR.colors.textField),
        onTextField = colorResource(MR.colors.onTextField),
    )

internal val LocalColorProvider =
    staticCompositionLocalOf<AppColors> { error("no default implementation") }