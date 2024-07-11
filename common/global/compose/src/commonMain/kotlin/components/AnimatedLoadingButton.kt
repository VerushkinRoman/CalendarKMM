package components

import CalendarTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import base_components.DefaultDSRButtonColors
import base_components.CalendarButtonWithCustomContent
import base_components.CalendarText

@Composable
fun AnimatedLoadingButton(
    isLoading: () -> Boolean,
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: () -> Boolean = { true },
    textStyle: TextStyle = CalendarTheme.typography.labelLarge,
    colors: ButtonColors = DefaultDSRButtonColors(),
) {
    val isEnabled by remember {
        derivedStateOf { enabled() && !isLoading() }
    }

    CalendarButtonWithCustomContent(
        onClick = onClick,
        enabled = isEnabled,
        colors = colors,
        modifier = modifier
    ) {
        Box(contentAlignment = Alignment.Center) {
            if (isLoading()) SpinningProgressBar(Modifier.size(textStyle.fontSize.value.dp))

            CalendarText(
                text = text,
                textAlign = TextAlign.Center,
                color = LocalContentColor.current,
                style = textStyle,
                singleLine = true,
                modifier = Modifier.graphicsLayer { alpha = if (isLoading()) 0f else 1f }
            )
        }
    }
}