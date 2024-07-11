package base_components

import CalendarTheme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp

@Composable
fun CalendarButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape = CircleShape,
    border: BorderStroke? = null,
    colors: ButtonColors = DefaultDSRButtonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    text: String
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding
    ) {
        CalendarText(
            text = text,
            style = CalendarTheme.typography.bodyMedium,
            color = LocalContentColor.current,
            singleLine = true
        )
    }
}

@Composable
fun CalendarSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape = CircleShape,
    border: BorderStroke? = null,
    colors: ButtonColors = DefaultDSRSecondaryButtonColors(),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    text: String
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding
    ) {
        CalendarText(
            text = text,
            style = CalendarTheme.typography.bodyMedium,
            color = LocalContentColor.current,
            singleLine = true
        )
    }
}

@Composable
fun CalendarButtonWithCustomContent(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = null,
    shape: Shape = CircleShape,
    border: BorderStroke? = null,
    colors: ButtonColors = DefaultDSRButtonColors(),
    contentPadding: PaddingValues = calendarMinimalVerticalPaddings,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        elevation = elevation,
        shape = shape,
        border = border,
        colors = colors,
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun DefaultDSRButtonColors(
    containerColor: Color = CalendarTheme.colorScheme.primary,
    contentColor: Color = CalendarTheme.colorScheme.onPrimary,
    disabledContainerColor: Color = containerColor.copy(alpha = 0.5f),
    disabledContentColor: Color = contentColor.copy(alpha = 0.5f)
): ButtonColors =
    ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

@Composable
fun DefaultDSRSecondaryButtonColors(
    containerColor: Color = CalendarTheme.colorScheme.secondary,
    contentColor: Color = CalendarTheme.colorScheme.onSecondary,
    disabledContainerColor: Color = containerColor.copy(alpha = 0.5f),
    disabledContentColor: Color = contentColor.copy(alpha = 0.5f)
): ButtonColors =
    ButtonDefaults.buttonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

internal val calendarMinimalVerticalPaddings: PaddingValues
    @Composable get() {
        val default = ButtonDefaults.ContentPadding
        val layoutDirection = LocalLayoutDirection.current
        return PaddingValues(
            start = default.calculateStartPadding(layoutDirection),
            top = 2.dp,
            end = default.calculateEndPadding(layoutDirection),
            bottom = 2.dp
        )
    }