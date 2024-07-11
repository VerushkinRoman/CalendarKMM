package components

import androidx.compose.runtime.Composable

@Composable
actual fun AndroidBackButtonHandler(
    enabled: Boolean,
    onBackRequest: () -> Unit
) = BackButtonHandlerMultiplatform(
    enabled = enabled,
    onBackRequest = onBackRequest
)