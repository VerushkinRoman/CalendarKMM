package components

import CalendarTheme
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun CustomDivider(
    horizontal: Boolean = true,
    lineColor: Color = CalendarTheme.colorScheme.onBackground,
    modifier: Modifier
) {
    val density = LocalDensity.current
    val elementSize = remember { with(density) { 3.dp.toPx() } }
    val lineThickness = remember { with(density) { 1.dp.toPx() } }

    Canvas(modifier = modifier) {
        val size = if (horizontal) size.width else size.height
        val elementsCount = (size / elementSize).toInt()
        repeat(elementsCount) { element ->
            if (element % 2 != 0) drawLine(
                color = lineColor,
                start = Offset(
                    x = if (horizontal) element * elementSize else 0F,
                    y = if (horizontal) 0F else element * elementSize
                ),
                end = Offset(
                    x = if (horizontal) element * elementSize + elementSize else 0F,
                    y = if (horizontal) 0F else element * elementSize + elementSize
                ),
                strokeWidth = lineThickness,
                cap = StrokeCap.Round
            )
        }
    }
}