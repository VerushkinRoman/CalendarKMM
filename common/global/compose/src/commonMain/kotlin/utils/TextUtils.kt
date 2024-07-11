package utils

import CalendarTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun errorTextHeight(
    lines: Int = 1
): Dp {
    val lineHeight = CalendarTheme.typography.labelMedium.fontSize * 4 / 3
    return with(LocalDensity.current) { (lineHeight * lines).toDp() } + 3.dp
}
