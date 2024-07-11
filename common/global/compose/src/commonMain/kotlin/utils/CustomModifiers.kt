package utils

import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import domain.MultipleEventsCutter
import domain.get

@Composable
fun Modifier.clickableSingle(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    indication: Indication? = LocalIndication.current,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) = composed(
    inspectorInfo = debugInspectorInfo {
        name = "clickable"
        properties["enabled"] = enabled
        properties["onClickLabel"] = onClickLabel
        properties["role"] = role
        properties["onClick"] = onClick
    }
) {
    val multipleEventsCutter = remember { MultipleEventsCutter.get() }
    Modifier.clickable(
        enabled = enabled,
        onClickLabel = onClickLabel,
        onClick = { multipleEventsCutter.processEvent { onClick() } },
        role = role,
        indication = indication,
        interactionSource = interactionSource
    )
}

fun Modifier.exceptBottomPadding(paddingValues: PaddingValues) = composed {
    val layoutDirection = LocalLayoutDirection.current

    val newPaddings = PaddingValues(
        top = paddingValues.calculateTopPadding(),
        bottom = 0.dp,
        end = paddingValues.calculateEndPadding(layoutDirection),
        start = paddingValues.calculateStartPadding(layoutDirection)
    )

    Modifier.padding(newPaddings)
}

fun Modifier.onlyHorizontalPaddings(paddingValues: PaddingValues) = composed {
    val layoutDirection = LocalLayoutDirection.current

    val newPaddings = PaddingValues(
        top = 0.dp,
        bottom = 0.dp,
        end = paddingValues.calculateEndPadding(layoutDirection),
        start = paddingValues.calculateStartPadding(layoutDirection)
    )

    Modifier.padding(newPaddings)
}

fun Modifier.extendedWidth(
    width: Dp = 8.dp
) = layout { measurable, constraints ->
    val newWidth = constraints.maxWidth + width.roundToPx()

    val newConstraints = constraints.copy(
        minWidth = newWidth,
        maxWidth = newWidth
    )
    val placeable = measurable.measure(newConstraints)

    layout(newWidth, placeable.height) {
        placeable.place(x = 0, y = 0)
    }
}