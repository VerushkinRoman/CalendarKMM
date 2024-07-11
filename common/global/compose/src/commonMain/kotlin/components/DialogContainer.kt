package components

import CalendarTheme
import UiConstants.commonButtonShape
import UiConstants.spacerSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import base_components.CalendarButton
import base_components.CalendarButtonWithCustomContent
import base_components.CalendarSecondaryButton
import base_components.CalendarText
import domain.MultipleEventsCutter
import domain.get
import kotlinx.coroutines.launch
import resources.MR
import utils.ResourceProvider.getString

@Composable
fun DialogContainer(
    headerText: String? = null,
    customHeader: (@Composable () -> Unit)? = null,
    confirmText: String? = null,
    customConfirmText: (@Composable () -> Unit)? = null,
    confirmAction: () -> Unit,
    showCloseCross: Boolean = true,
    confirmEnabled: () -> Boolean = { true },
    cancelText: String? = null,
    cancelAction: () -> Unit,
    backButtonAction: () -> Unit = cancelAction,
    useDivider: Boolean = true,
    startPadding: Dp = 0.dp,
    endPadding: Dp = 0.dp,
    body: (@Composable (maxWidth: Dp) -> Unit)?
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(CalendarTheme.colorScheme.shadow)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {}
            )
            .draggable(
                rememberDraggableState {},
                orientation = Orientation.Vertical
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(Modifier.weight(1f))

            DialogWindow(
                headerText = headerText,
                customHeader = customHeader,
                confirmText = confirmText,
                customConfirmText = customConfirmText,
                confirmAction = confirmAction,
                confirmEnabled = confirmEnabled,
                cancelText = cancelText,
                cancelAction = cancelAction,
                body = body,
                showCloseCross = showCloseCross,
                maxWidth = this@BoxWithConstraints.maxWidth,
                maxHeight = this@BoxWithConstraints.maxHeight,
                useDivider = useDivider,
                startPadding = startPadding,
                endPadding = endPadding,
            )

            Spacer(Modifier.weight(1f))
        }
    }

    AndroidBackButtonHandler(onBackRequest = backButtonAction)
}

@Composable
private fun DialogWindow(
    headerText: String?,
    customHeader: (@Composable () -> Unit)?,
    confirmText: String?,
    customConfirmText: (@Composable () -> Unit)?,
    confirmAction: () -> Unit,
    confirmEnabled: () -> Boolean,
    cancelText: String?,
    cancelAction: () -> Unit,
    showCloseCross: Boolean,
    body: (@Composable (maxWidth: Dp) -> Unit)?,
    maxWidth: Dp,
    maxHeight: Dp,
    useDivider: Boolean,
    startPadding: Dp,
    endPadding: Dp,
) {
    val dialogPadding = spacerSize

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .imePadding()
            .padding(start = startPadding, end = endPadding)
            .widthIn(max = (maxWidth - startPadding - endPadding) * 0.8f)
            .heightIn(max = maxHeight * 0.8f)
            .clip(commonButtonShape)
            .background(CalendarTheme.colorScheme.background)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {}
            )
            .padding(dialogPadding)
    ) {
        Column(
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            HeaderBlock(
                headerText = headerText,
                customHeader = customHeader,
                cancelAction = cancelAction,
                showCloseCross = showCloseCross,
                headerPadding = dialogPadding,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(spacerSize))

            if (useDivider) {
                CustomDivider(modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(spacerSize))
            }

            body?.let {
                BodyBlock(
                    body = body,
                    maxWidth = maxWidth - dialogPadding * 2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }

            if (confirmText != null || customConfirmText != null) {
                Spacer(Modifier.height(spacerSize))

                ButtonsBlock(
                    confirmText = confirmText,
                    customConfirmText = customConfirmText,
                    confirmAction = confirmAction,
                    confirmEnabled = confirmEnabled,
                    cancelText = cancelText,
                    cancelAction = cancelAction,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun HeaderBlock(
    headerText: String?,
    customHeader: (@Composable () -> Unit)?,
    cancelAction: () -> Unit,
    showCloseCross: Boolean,
    headerPadding: Dp,
    modifier: Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        customHeader?.let { it() }

        headerText?.let {
            CalendarText(
                text = it,
                style = CalendarTheme.typography.bodyLarge,
                maxLines = 3
            )
        }

        if (showCloseCross) {
            IconButton(
                onClick = cancelAction,
                modifier = Modifier
                    .offset(x = headerPadding - 4.dp, y = -headerPadding + 4.dp)
                    .align(Alignment.TopEnd)
                    .clip(CircleShape)
            ) {
                Image(
                    imageVector = Icons.Default.Close,
                    contentDescription = getString(MR.strings.close),
                    colorFilter = ColorFilter.tint(color = CalendarTheme.colorScheme.onBackground),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = CalendarTheme.colorScheme.secondary,
                            shape = CircleShape
                        )
                        .padding(4.dp)
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
private fun BodyBlock(
    modifier: Modifier,
    maxWidth: Dp,
    body: @Composable (maxWidth: Dp) -> Unit,
) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .draggable(
                rememberDraggableState {
                    scope.launch {
                        scrollState.scrollBy(-it)
                    }
                },
                orientation = Orientation.Vertical
            )
    ) {
        body(maxWidth)
    }
}

@Composable
private fun ButtonsBlock(
    confirmText: String?,
    customConfirmText: (@Composable () -> Unit)?,
    confirmAction: () -> Unit,
    confirmEnabled: () -> Boolean = { true },
    cancelText: String? = null,
    cancelAction: () -> Unit,
    modifier: Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        val multipleEventsCutter = remember { MultipleEventsCutter.get() }

        ConfirmButton(
            confirmText = confirmText,
            customConfirmText = customConfirmText,
            confirmAction = confirmAction,
            confirmEnabled = confirmEnabled,
            multipleEventsCutter = multipleEventsCutter,
            modifier = if (cancelText == null) Modifier.fillMaxWidth(0.8f) else Modifier.weight(1f)
        )

        cancelText?.let { cancel ->
            Spacer(modifier = Modifier.width(spacerSize))

            CalendarSecondaryButton(
                text = cancel,
                onClick = { multipleEventsCutter.processEvent { cancelAction() } },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ConfirmButton(
    confirmText: String?,
    customConfirmText: (@Composable () -> Unit)?,
    confirmAction: () -> Unit,
    confirmEnabled: () -> Boolean,
    multipleEventsCutter: MultipleEventsCutter,
    modifier: Modifier
) {
    val onClickAction = { multipleEventsCutter.processEvent { confirmAction() } }

    customConfirmText?.let {
        CalendarButtonWithCustomContent(
            onClick = onClickAction,
            enabled = confirmEnabled(),
            modifier = modifier
        ) {
            customConfirmText()
        }
    }

    confirmText?.let {
        CalendarButton(
            text = it,
            onClick = onClickAction,
            enabled = confirmEnabled(),
            modifier = modifier
        )
    }
}