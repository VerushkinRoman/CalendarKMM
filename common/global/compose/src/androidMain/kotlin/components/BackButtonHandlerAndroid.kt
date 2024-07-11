package components

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable

@Composable
actual fun AndroidBackButtonHandler(
    enabled: Boolean,
    onBackRequest: () -> Unit
) = BackHandler(
    enabled = enabled,
    onBack = onBackRequest
)