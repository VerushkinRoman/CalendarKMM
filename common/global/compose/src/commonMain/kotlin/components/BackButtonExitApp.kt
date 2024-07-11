package components

import androidx.compose.runtime.Composable

@Composable
expect fun BackButtonExitApp(enabled: () -> Boolean = { true })