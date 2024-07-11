package components

import CalendarTheme
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import base_components.CalendarText
import kotlinx.coroutines.delay
import model.ComponentOpacity
import utils.errorTextHeight
import utils.getStandardAnimation

@Composable
fun ErrorHelperText(
    errorText: String,
    minLines: Int = 1,
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf(errorText) }

    var textOpacity by remember { mutableStateOf(ComponentOpacity.Transparent) }

    LaunchedEffect(key1 = errorText) {
        textOpacity = if (errorText.isNotEmpty()) {
            textOpacity = ComponentOpacity.Transparent
            delay(300)
            text = errorText
            ComponentOpacity.Solid
        } else ComponentOpacity.Transparent
    }

    val appearanceAnimation by animateFloatAsState(
        when (textOpacity) {
            ComponentOpacity.Solid -> 1f
            ComponentOpacity.Transparent -> 0f
        },
        getStandardAnimation()
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = when (textAlign) {
            TextAlign.Center -> Arrangement.Center
            TextAlign.End, TextAlign.Right -> Arrangement.End
            else -> Arrangement.Start
        },
        modifier = modifier.padding(top = 3.dp).graphicsLayer { alpha = appearanceAnimation }
    ) {
        val lineHeight = CalendarTheme.typography.labelMedium.fontSize * 4 / 3

        CalendarText(
            text = text,
            color = CalendarTheme.colorScheme.error,
            textAlign = textAlign,
            style = CalendarTheme.typography.labelMedium,
            maxLines = 2,
            lineHeight = lineHeight,
            modifier = Modifier.sizeIn(minHeight = errorTextHeight(minLines))
        )
    }
}