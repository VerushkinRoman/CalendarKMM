package components

import androidx.compose.runtime.Composable

@Composable
expect fun AndroidBackButtonHandler(
    enabled: Boolean = true,
    onBackRequest: () -> Unit
)

@Suppress("UNUSED_PARAMETER")
@Composable
fun BackButtonHandlerMultiplatform(
    enabled: Boolean,
    onBackRequest: () -> Unit
) = Unit
