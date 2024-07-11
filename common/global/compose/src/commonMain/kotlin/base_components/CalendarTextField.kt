@file:Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")

package base_components

import CalendarTheme
import UiConstants.spacerSize
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ContainerId
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalIconPadding
import androidx.compose.material3.LabelId
import androidx.compose.material3.LeadingId
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MinFocusedLabelLineHeight
import androidx.compose.material3.MinSupportingTextLineHeight
import androidx.compose.material3.MinTextLineHeight
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldTopPadding
import androidx.compose.material3.PlaceholderId
import androidx.compose.material3.PrefixId
import androidx.compose.material3.PrefixSuffixTextPadding
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Strings
import androidx.compose.material3.SuffixId
import androidx.compose.material3.SupportingId
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldId
import androidx.compose.material3.TrailingId
import androidx.compose.material3.ZeroConstraints
import androidx.compose.material3.getString
import androidx.compose.material3.heightOrZero
import androidx.compose.material3.layoutId
import androidx.compose.material3.outlineCutout
import androidx.compose.material3.widthOrZero
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.layout.IntrinsicMeasurable
import androidx.compose.ui.layout.IntrinsicMeasureScope
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset
import kotlin.math.max
import kotlin.math.roundToInt

@Composable
fun CalendarTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = CalendarTheme.typography.bodyMedium,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = CircleShape,
    colors: TextFieldColors = DefaultDSRTextFieldColors()
) = CustomTextField(
    value = value,
    onValueChange = onValueChange,
    modifier = modifier,
    enabled = enabled,
    readOnly = readOnly,
    textStyle = textStyle,
    label = label,
    placeholder = placeholder,
    leadingIcon = leadingIcon,
    trailingIcon = trailingIcon,
    isError = isError,
    visualTransformation = visualTransformation,
    keyboardOptions = keyboardOptions,
    keyboardActions = keyboardActions,
    singleLine = singleLine,
    maxLines = maxLines,
    interactionSource = interactionSource,
    shape = shape,
    colors = colors
)

@Composable
fun CalendarTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = CalendarTheme.typography.bodyMedium,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = CircleShape,
    colors: TextFieldColors = DefaultDSRTextFieldColors()
) = CustomTextField(
    value = value,
    onValueChange = onValueChange,
    modifier = modifier,
    enabled = enabled,
    readOnly = readOnly,
    textStyle = textStyle,
    label = label,
    placeholder = placeholder,
    leadingIcon = leadingIcon,
    trailingIcon = trailingIcon,
    isError = isError,
    visualTransformation = visualTransformation,
    keyboardOptions = keyboardOptions,
    keyboardActions = keyboardActions,
    singleLine = singleLine,
    maxLines = maxLines,
    interactionSource = interactionSource,
    shape = shape,
    colors = colors
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    textStyle: TextStyle,
    label: @Composable (() -> Unit)?,
    placeholder: @Composable (() -> Unit)?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    isError: Boolean,
    visualTransformation: VisualTransformation,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    maxLines: Int,
    interactionSource: MutableInteractionSource,
    shape: Shape,
    colors: TextFieldColors
) {
    val textColor = textStyle.color.takeOrElse {
        colors.textColor(enabled, isError, interactionSource).value
    }
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    CompositionLocalProvider(LocalTextSelectionColors provides colors.selectionColors) {
        BasicTextField(
            value = value,
            modifier = if (label != null) {
                modifier
                    .semantics(mergeDescendants = true) {}
                    .padding(top = OutlinedTextFieldTopPadding)
            } else {
                modifier
            }
                .defaultMinSize(
                    minWidth = OutlinedTextFieldDefaults.MinWidth,
                    minHeight = OutlinedTextFieldDefaults.MinHeight
                ),
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = mergedTextStyle,
            cursorBrush = SolidColor(colors.cursorColor(isError).value),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
            singleLine = singleLine,
            maxLines = maxLines,
            decorationBox = @Composable { innerTextField ->
                DecorationBox(
                    value = value,
                    visualTransformation = visualTransformation,
                    innerTextField = innerTextField,
                    placeholder = placeholder,
                    label = label,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    prefix = null,
                    suffix = null,
                    supportingText = null,
                    singleLine = singleLine,
                    enabled = enabled,
                    isError = isError,
                    interactionSource = interactionSource,
                    colors = colors,
                    contentPadding = PaddingValues(horizontal = spacerSize),
                    container = {
                        OutlinedTextFieldDefaults.ContainerBox(
                            enabled,
                            isError,
                            interactionSource,
                            colors,
                            shape
                        )
                    }
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    readOnly: Boolean,
    textStyle: TextStyle,
    label: @Composable (() -> Unit)?,
    placeholder: @Composable (() -> Unit)?,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    isError: Boolean,
    visualTransformation: VisualTransformation,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    singleLine: Boolean,
    maxLines: Int,
    interactionSource: MutableInteractionSource,
    shape: Shape,
    colors: TextFieldColors
) {
    val textColor = textStyle.color.takeOrElse {
        colors.textColor(enabled, isError, interactionSource).value
    }
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    CompositionLocalProvider(LocalTextSelectionColors provides colors.selectionColors) {
        BasicTextField(
            value = value,
            modifier = if (label != null) {
                modifier
                    .semantics(mergeDescendants = true) {}
                    .padding(top = OutlinedTextFieldTopPadding)
            } else {
                modifier
            }
                .defaultMinSize(
                    minWidth = OutlinedTextFieldDefaults.MinWidth,
                    minHeight = OutlinedTextFieldDefaults.MinHeight
                ),
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            textStyle = mergedTextStyle,
            cursorBrush = SolidColor(colors.cursorColor(isError).value),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
            singleLine = singleLine,
            maxLines = maxLines,
            decorationBox = @Composable { innerTextField ->
                DecorationBox(
                    value = value.text,
                    visualTransformation = visualTransformation,
                    innerTextField = innerTextField,
                    placeholder = placeholder,
                    label = label,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon,
                    prefix = null,
                    suffix = null,
                    supportingText = null,
                    singleLine = singleLine,
                    enabled = enabled,
                    isError = isError,
                    interactionSource = interactionSource,
                    colors = colors,
                    contentPadding = PaddingValues(horizontal = spacerSize),
                    container = {
                        OutlinedTextFieldDefaults.ContainerBox(
                            enabled,
                            isError,
                            interactionSource,
                            colors,
                            shape
                        )
                    }
                )
            }
        )
    }
}

@Composable
fun DefaultDSRTextFieldColors(
    focusedTextColor: Color = CalendarTheme.colorScheme.onTextField,
    unfocusedTextColor: Color = CalendarTheme.colorScheme.onTextField,
    disabledTextColor: Color = CalendarTheme.colorScheme.onTextField,
    errorTextColor: Color = CalendarTheme.colorScheme.error,
    focusedContainerColor: Color = CalendarTheme.colorScheme.textField,
    unfocusedContainerColor: Color = CalendarTheme.colorScheme.textField,
    disabledContainerColor: Color = CalendarTheme.colorScheme.textField,
    errorContainerColor: Color = CalendarTheme.colorScheme.textField,
    cursorColor: Color = CalendarTheme.colorScheme.onTextField,
    errorCursorColor: Color = CalendarTheme.colorScheme.error,
    selectionColors: TextSelectionColors = LocalTextSelectionColors.current,
    focusedBorderColor: Color = CalendarTheme.colorScheme.onTextField,
    unfocusedBorderColor: Color = Color.Transparent,
    disabledBorderColor: Color = Color.Transparent,
    errorBorderColor: Color = CalendarTheme.colorScheme.error,
    focusedLeadingIconColor: Color = CalendarTheme.colorScheme.onTextField,
    unfocusedLeadingIconColor: Color = CalendarTheme.colorScheme.onTextField,
    disabledLeadingIconColor: Color = CalendarTheme.colorScheme.onTextField,
    errorLeadingIconColor: Color = CalendarTheme.colorScheme.onTextField,
    focusedTrailingIconColor: Color = CalendarTheme.colorScheme.onTextField,
    unfocusedTrailingIconColor: Color = CalendarTheme.colorScheme.onTextField,
    disabledTrailingIconColor: Color = CalendarTheme.colorScheme.onTextField,
    errorTrailingIconColor: Color = CalendarTheme.colorScheme.onTextField,
    focusedLabelColor: Color = CalendarTheme.colorScheme.onTextField,
    unfocusedLabelColor: Color = CalendarTheme.colorScheme.onTextField,
    disabledLabelColor: Color = CalendarTheme.colorScheme.onTextField,
    errorLabelColor: Color = CalendarTheme.colorScheme.error,
    focusedPlaceholderColor: Color = CalendarTheme.colorScheme.onTextField,
    unfocusedPlaceholderColor: Color = CalendarTheme.colorScheme.onTextField,
    disabledPlaceholderColor: Color = CalendarTheme.colorScheme.onTextField,
    errorPlaceholderColor: Color = CalendarTheme.colorScheme.onTextField,
    focusedSupportingTextColor: Color = CalendarTheme.colorScheme.onTextField,
    unfocusedSupportingTextColor: Color = CalendarTheme.colorScheme.onTextField,
    disabledSupportingTextColor: Color = CalendarTheme.colorScheme.onTextField,
    errorSupportingTextColor: Color = CalendarTheme.colorScheme.error,
    focusedPrefixColor: Color = CalendarTheme.colorScheme.onTextField,
    unfocusedPrefixColor: Color = CalendarTheme.colorScheme.onTextField,
    disabledPrefixColor: Color = CalendarTheme.colorScheme.onTextField,
    errorPrefixColor: Color = CalendarTheme.colorScheme.onTextField,
    focusedSuffixColor: Color = CalendarTheme.colorScheme.onTextField,
    unfocusedSuffixColor: Color = CalendarTheme.colorScheme.onTextField,
    disabledSuffixColor: Color = CalendarTheme.colorScheme.onTextField,
    errorSuffixColor: Color = CalendarTheme.colorScheme.onTextField,
): TextFieldColors = OutlinedTextFieldDefaults.colors(
    focusedTextColor = focusedTextColor,
    unfocusedTextColor = unfocusedTextColor,
    disabledTextColor = disabledTextColor,
    errorTextColor = errorTextColor,
    focusedContainerColor = focusedContainerColor,
    unfocusedContainerColor = unfocusedContainerColor,
    disabledContainerColor = disabledContainerColor,
    errorContainerColor = errorContainerColor,
    cursorColor = cursorColor,
    errorCursorColor = errorCursorColor,
    selectionColors = selectionColors,
    focusedBorderColor = focusedBorderColor,
    unfocusedBorderColor = unfocusedBorderColor,
    disabledBorderColor = disabledBorderColor,
    errorBorderColor = errorBorderColor,
    focusedLeadingIconColor = focusedLeadingIconColor,
    unfocusedLeadingIconColor = unfocusedLeadingIconColor,
    disabledLeadingIconColor = disabledLeadingIconColor,
    errorLeadingIconColor = errorLeadingIconColor,
    focusedTrailingIconColor = focusedTrailingIconColor,
    unfocusedTrailingIconColor = unfocusedTrailingIconColor,
    disabledTrailingIconColor = disabledTrailingIconColor,
    errorTrailingIconColor = errorTrailingIconColor,
    focusedLabelColor = focusedLabelColor,
    unfocusedLabelColor = unfocusedLabelColor,
    disabledLabelColor = disabledLabelColor,
    errorLabelColor = errorLabelColor,
    focusedPlaceholderColor = focusedPlaceholderColor,
    unfocusedPlaceholderColor = unfocusedPlaceholderColor,
    disabledPlaceholderColor = disabledPlaceholderColor,
    errorPlaceholderColor = errorPlaceholderColor,
    focusedSupportingTextColor = focusedSupportingTextColor,
    unfocusedSupportingTextColor = unfocusedSupportingTextColor,
    disabledSupportingTextColor = disabledSupportingTextColor,
    errorSupportingTextColor = errorSupportingTextColor,
    focusedPrefixColor = focusedPrefixColor,
    unfocusedPrefixColor = unfocusedPrefixColor,
    disabledPrefixColor = disabledPrefixColor,
    errorPrefixColor = errorPrefixColor,
    focusedSuffixColor = focusedSuffixColor,
    unfocusedSuffixColor = unfocusedSuffixColor,
    disabledSuffixColor = disabledSuffixColor,
    errorSuffixColor = errorSuffixColor
)

@Composable
private fun DecorationBox(
    value: String,
    innerTextField: @Composable () -> Unit,
    visualTransformation: VisualTransformation,
    label: @Composable (() -> Unit)?,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    singleLine: Boolean = false,
    enabled: Boolean = true,
    isError: Boolean = false,
    interactionSource: InteractionSource,
    contentPadding: PaddingValues,
    colors: TextFieldColors,
    container: @Composable () -> Unit,
) {
    val transformedText = remember(value, visualTransformation) {
        visualTransformation.filter(AnnotatedString(value))
    }.text.text

    val isFocused = interactionSource.collectIsFocusedAsState().value
    val inputState = when {
        isFocused -> InputPhase.Focused
        transformedText.isEmpty() -> InputPhase.UnfocusedEmpty
        else -> InputPhase.UnfocusedNotEmpty
    }

    val labelColor: @Composable (InputPhase) -> Color = {
        colors.labelColor(enabled, isError, interactionSource).value
    }

    TextFieldTransitionScope.Transition(
        inputState = inputState,
        focusedTextStyleColor = CalendarTheme.colorScheme.onTextField.takeOrElse {
            labelColor(
                inputState
            )
        },
        unfocusedTextStyleColor = CalendarTheme.colorScheme.onTextField.takeOrElse {
            labelColor(
                inputState
            )
        },
        contentColor = labelColor,
        showLabel = label != null
    ) { labelProgress, _, labelContentColor, placeholderAlphaProgress,
        prefixSuffixAlphaProgress ->

        val decoratedLabel: @Composable (() -> Unit)? = label?.let {
            @Composable {
                Decoration(labelContentColor, CalendarTheme.typography.labelSmall, it)
            }
        }

        // Transparent components interfere with Talkback (b/261061240), so if any components below
        // have alpha == 0, we set the component to null instead.

        val decoratedPlaceholder: @Composable ((Modifier) -> Unit)? =
            if (placeholder != null && transformedText.isEmpty() && placeholderAlphaProgress > 0f) {
                @Composable { modifier ->
                    Box(modifier.alpha(placeholderAlphaProgress)) {
                        Decoration(
                            contentColor =
                            colors.placeholderColor(enabled, isError, interactionSource).value,
                            typography = CalendarTheme.typography.bodyLarge,
                            content = placeholder
                        )
                    }
                }
            } else null

        val prefixColor = colors.prefixColor(enabled, isError, interactionSource).value
        val decoratedPrefix: @Composable (() -> Unit)? =
            if (prefix != null && prefixSuffixAlphaProgress > 0f) {
                @Composable {
                    Box(Modifier.alpha(prefixSuffixAlphaProgress)) {
                        Decoration(
                            contentColor = prefixColor,
                            typography = CalendarTheme.typography.bodyMedium,
                            content = prefix
                        )
                    }
                }
            } else null

        val suffixColor = colors.suffixColor(enabled, isError, interactionSource).value
        val decoratedSuffix: @Composable (() -> Unit)? =
            if (suffix != null && prefixSuffixAlphaProgress > 0f) {
                @Composable {
                    Box(Modifier.alpha(prefixSuffixAlphaProgress)) {
                        Decoration(
                            contentColor = suffixColor,
                            typography = CalendarTheme.typography.bodyMedium,
                            content = suffix
                        )
                    }
                }
            } else null

        // Developers need to handle invalid input manually. But since we don't provide error
        // message slot API, we can set the default error message in case developers forget about
        // it.
        val defaultErrorMessage = getString(Strings.DefaultErrorMessage)
        val decorationBoxModifier = Modifier.semantics { if (isError) error(defaultErrorMessage) }

        val leadingIconColor = colors.leadingIconColor(enabled, isError, interactionSource).value
        val decoratedLeading: @Composable (() -> Unit)? = leadingIcon?.let {
            @Composable {
                Decoration(contentColor = leadingIconColor, content = it)
            }
        }

        val trailingIconColor = colors.trailingIconColor(enabled, isError, interactionSource).value
        val decoratedTrailing: @Composable (() -> Unit)? = trailingIcon?.let {
            @Composable {
                Decoration(contentColor = trailingIconColor, content = it)
            }
        }

        val supportingTextColor =
            colors.supportingTextColor(enabled, isError, interactionSource).value
        val decoratedSupporting: @Composable (() -> Unit)? = supportingText?.let {
            @Composable {
                Decoration(
                    contentColor = supportingTextColor,
                    typography = CalendarTheme.typography.labelSmall,
                    content = it
                )
            }
        }

        // Outlined cutout
        val labelSize = remember { mutableStateOf(Size.Zero) }
        val borderContainerWithId: @Composable () -> Unit = {
            Box(
                Modifier
                    .layoutId(ContainerId)
                    .outlineCutout(labelSize.value, contentPadding),
                propagateMinConstraints = true
            ) {
                container()
            }
        }

        OutlinedTextFieldLayout(
            modifier = decorationBoxModifier,
            textField = innerTextField,
            placeholder = decoratedPlaceholder,
            label = decoratedLabel,
            leading = decoratedLeading,
            trailing = decoratedTrailing,
            prefix = decoratedPrefix,
            suffix = decoratedSuffix,
            supporting = decoratedSupporting,
            singleLine = singleLine,
            onLabelMeasured = {
                val labelWidth = it.width * labelProgress
                val labelHeight = it.height * labelProgress
                if (labelSize.value.width != labelWidth ||
                    labelSize.value.height != labelHeight
                ) {
                    labelSize.value = Size(labelWidth, labelHeight)
                }
            },
            animationProgress = labelProgress,
            container = borderContainerWithId,
            paddingValues = contentPadding
        )
    }
}

/**
 * Set content color, typography and emphasis for [content] composable
 */
@Composable
private fun Decoration(
    contentColor: Color,
    typography: TextStyle? = null,
    content: @Composable () -> Unit
) {
    val contentWithColor: @Composable () -> Unit = @Composable {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            content = content
        )
    }
    if (typography != null) ProvideTextStyle(typography, contentWithColor) else contentWithColor()
}

private object TextFieldTransitionScope {
    @Composable
    fun Transition(
        inputState: InputPhase,
        focusedTextStyleColor: Color,
        unfocusedTextStyleColor: Color,
        contentColor: @Composable (InputPhase) -> Color,
        showLabel: Boolean,
        content: @Composable (
            labelProgress: Float,
            labelTextStyleColor: Color,
            labelContentColor: Color,
            placeholderOpacity: Float,
            prefixSuffixOpacity: Float,
        ) -> Unit
    ) {
        // Transitions from/to InputPhase.Focused are the most critical in the transition below.
        // UnfocusedEmpty <-> UnfocusedNotEmpty are needed when a single state is used to control
        // multiple text fields.
        val transition = updateTransition(inputState, label = "TextFieldInputState")

        val labelProgress by transition.animateFloat(
            label = "LabelProgress",
            transitionSpec = { tween(durationMillis = androidx.compose.material3.AnimationDuration) }
        ) {
            when (it) {
                InputPhase.Focused -> 1f
                InputPhase.UnfocusedEmpty -> 0f
                InputPhase.UnfocusedNotEmpty -> 1f
            }
        }

        val placeholderOpacity by transition.animateFloat(
            label = "PlaceholderOpacity",
            transitionSpec = {
                if (InputPhase.Focused isTransitioningTo InputPhase.UnfocusedEmpty) {
                    tween(
                        durationMillis = PlaceholderAnimationDelayOrDuration,
                        easing = LinearEasing
                    )
                } else if (InputPhase.UnfocusedEmpty isTransitioningTo InputPhase.Focused ||
                    InputPhase.UnfocusedNotEmpty isTransitioningTo InputPhase.UnfocusedEmpty
                ) {
                    tween(
                        durationMillis = PlaceholderAnimationDuration,
                        delayMillis = PlaceholderAnimationDelayOrDuration,
                        easing = LinearEasing
                    )
                } else {
                    spring()
                }
            }
        ) {
            when (it) {
                InputPhase.Focused -> 1f
                InputPhase.UnfocusedEmpty -> if (showLabel) 0f else 1f
                InputPhase.UnfocusedNotEmpty -> 0f
            }
        }

        val prefixSuffixOpacity by transition.animateFloat(
            label = "PrefixSuffixOpacity",
            transitionSpec = { tween(durationMillis = androidx.compose.material3.AnimationDuration) }
        ) {
            when (it) {
                InputPhase.Focused -> 1f
                InputPhase.UnfocusedEmpty -> if (showLabel) 0f else 1f
                InputPhase.UnfocusedNotEmpty -> 1f
            }
        }

        val labelTextStyleColor by transition.animateColor(
            transitionSpec = { tween(durationMillis = androidx.compose.material3.AnimationDuration) },
            label = "LabelTextStyleColor"
        ) {
            when (it) {
                InputPhase.Focused -> focusedTextStyleColor
                else -> unfocusedTextStyleColor
            }
        }

        val labelContentColor by transition.animateColor(
            transitionSpec = { tween(durationMillis = androidx.compose.material3.AnimationDuration) },
            label = "LabelContentColor",
            targetValueByState = contentColor
        )

        content(
            labelProgress,
            labelTextStyleColor,
            labelContentColor,
            placeholderOpacity,
            prefixSuffixOpacity,
        )
    }
}

/**
 * An internal state used to animate a label and an indicator.
 */
private enum class InputPhase {
    // Text field is focused
    Focused,

    // Text field is not focused and input text is empty
    UnfocusedEmpty,

    // Text field is not focused but input text is not empty
    UnfocusedNotEmpty
}

private const val PlaceholderAnimationDuration = 83
private const val PlaceholderAnimationDelayOrDuration = 67

private val IconDefaultSizeModifier: Modifier
    @Composable get() = Modifier.size(24.dp)

@Composable
private fun OutlinedTextFieldLayout(
    modifier: Modifier,
    textField: @Composable () -> Unit,
    placeholder: @Composable ((Modifier) -> Unit)?,
    label: @Composable (() -> Unit)?,
    leading: @Composable (() -> Unit)?,
    trailing: @Composable (() -> Unit)?,
    prefix: @Composable (() -> Unit)?,
    suffix: @Composable (() -> Unit)?,
    singleLine: Boolean,
    animationProgress: Float,
    onLabelMeasured: (Size) -> Unit,
    container: @Composable () -> Unit,
    supporting: @Composable (() -> Unit)?,
    paddingValues: PaddingValues
) {
    val measurePolicy = remember(onLabelMeasured, singleLine, animationProgress, paddingValues) {
        OutlinedTextFieldMeasurePolicy(
            onLabelMeasured,
            singleLine,
            animationProgress,
            paddingValues
        )
    }
    val layoutDirection = LocalLayoutDirection.current
    Layout(
        modifier = modifier,
        content = {
            container()

            if (leading != null) {
                Box(
                    modifier = Modifier
                        .layoutId(LeadingId)
                        .padding(start = paddingValues.calculateStartPadding(layoutDirection))
                        .then(IconDefaultSizeModifier),
                    contentAlignment = Alignment.Center
                ) {
                    leading()
                }
            }
            if (trailing != null) {
                Box(
                    modifier = Modifier
                        .layoutId(TrailingId)
                        .padding(end = paddingValues.calculateEndPadding(layoutDirection))
                        .then(IconDefaultSizeModifier),
                    contentAlignment = Alignment.Center
                ) {
                    trailing()
                }
            }

            val startTextFieldPadding = paddingValues.calculateStartPadding(layoutDirection)
            val endTextFieldPadding = paddingValues.calculateEndPadding(layoutDirection)

            val startPadding = if (leading != null) {
                (startTextFieldPadding - HorizontalIconPadding).coerceAtLeast(0.dp)
            } else {
                startTextFieldPadding
            }
            val endPadding = if (trailing != null) {
                (endTextFieldPadding - HorizontalIconPadding).coerceAtLeast(0.dp)
            } else {
                endTextFieldPadding
            }

            if (prefix != null) {
                Box(
                    Modifier
                        .layoutId(PrefixId)
                        .heightIn(min = MinTextLineHeight)
                        .wrapContentHeight()
                        .padding(start = startPadding, end = PrefixSuffixTextPadding)
                ) {
                    prefix()
                }
            }
            if (suffix != null) {
                Box(
                    Modifier
                        .layoutId(SuffixId)
                        .heightIn(min = MinTextLineHeight)
                        .wrapContentHeight()
                        .padding(start = PrefixSuffixTextPadding, end = endPadding)
                ) {
                    suffix()
                }
            }

            val textPadding = Modifier
                .heightIn(min = MinTextLineHeight)
                .wrapContentHeight()
                .padding(
                    start = if (prefix == null) startPadding else 0.dp,
                    end = if (suffix == null) endPadding else 0.dp,
                )

            if (placeholder != null) {
                placeholder(
                    Modifier
                        .layoutId(PlaceholderId)
                        .then(textPadding)
                )
            }

            Box(
                modifier = Modifier
                    .layoutId(TextFieldId)
                    .then(textPadding),
                propagateMinConstraints = true
            ) {
                textField()
            }

            if (label != null) {
                Box(
                    Modifier
                        .heightIn(
                            min = androidx.compose.ui.unit.lerp(
                                MinTextLineHeight, MinFocusedLabelLineHeight, animationProgress
                            )
                        )
                        .wrapContentHeight()
                        .layoutId(LabelId)
                ) { label() }
            }

            if (supporting != null) {
                @OptIn(ExperimentalMaterial3Api::class)
                Box(
                    Modifier
                        .layoutId(SupportingId)
                        .heightIn(min = MinSupportingTextLineHeight)
                        .wrapContentHeight()
                        .padding(TextFieldDefaults.supportingTextPadding())
                ) { supporting() }
            }
        },
        measurePolicy = measurePolicy
    )
}

private class OutlinedTextFieldMeasurePolicy(
    private val onLabelMeasured: (Size) -> Unit,
    private val singleLine: Boolean,
    private val animationProgress: Float,
    private val paddingValues: PaddingValues
) : MeasurePolicy {
    override fun MeasureScope.measure(
        measurables: List<Measurable>,
        constraints: Constraints
    ): MeasureResult {
        var occupiedSpaceHorizontally = 0
        var occupiedSpaceVertically = 0
        val bottomPadding = paddingValues.calculateBottomPadding().roundToPx()

        val relaxedConstraints = constraints.copy(minWidth = 0, minHeight = 0)

        // measure leading icon
        val leadingPlaceable = measurables.find {
            it.layoutId == LeadingId
        }?.measure(relaxedConstraints)
        occupiedSpaceHorizontally += widthOrZero(leadingPlaceable)
        occupiedSpaceVertically = max(occupiedSpaceVertically, heightOrZero(leadingPlaceable))

        // measure trailing icon
        val trailingPlaceable = measurables.find { it.layoutId == TrailingId }
            ?.measure(relaxedConstraints.offset(horizontal = -occupiedSpaceHorizontally))
        occupiedSpaceHorizontally += widthOrZero(trailingPlaceable)
        occupiedSpaceVertically = max(occupiedSpaceVertically, heightOrZero(trailingPlaceable))

        // measure prefix
        val prefixPlaceable = measurables.find { it.layoutId == PrefixId }
            ?.measure(relaxedConstraints.offset(horizontal = -occupiedSpaceHorizontally))
        occupiedSpaceHorizontally += widthOrZero(prefixPlaceable)
        occupiedSpaceVertically = max(occupiedSpaceVertically, heightOrZero(prefixPlaceable))

        // measure suffix
        val suffixPlaceable = measurables.find { it.layoutId == SuffixId }
            ?.measure(relaxedConstraints.offset(horizontal = -occupiedSpaceHorizontally))
        occupiedSpaceHorizontally += widthOrZero(suffixPlaceable)
        occupiedSpaceVertically = max(occupiedSpaceVertically, heightOrZero(suffixPlaceable))

        // measure label
        val isLabelInMiddleSection = animationProgress < 1f
        val labelHorizontalPaddingOffset =
            paddingValues.calculateLeftPadding(layoutDirection).roundToPx() +
                    paddingValues.calculateRightPadding(layoutDirection).roundToPx()
        val labelConstraints = relaxedConstraints.offset(
            horizontal = if (isLabelInMiddleSection) {
                -occupiedSpaceHorizontally - labelHorizontalPaddingOffset
            } else {
                -labelHorizontalPaddingOffset
            },
            vertical = -bottomPadding
        )
        val labelPlaceable =
            measurables.find { it.layoutId == LabelId }?.measure(labelConstraints)
        labelPlaceable?.let {
            onLabelMeasured(Size(it.width.toFloat(), it.height.toFloat()))
        }

        // measure text field
        // On top, we offset either by default padding or by label's half height if its too big.
        // On bottom, we offset to make room for supporting text.
        // minHeight must not be set to 0 due to how foundation TextField treats zero minHeight.
        val topPadding = max(
            heightOrZero(labelPlaceable) / 2,
            paddingValues.calculateTopPadding().roundToPx()
        )
        val textConstraints = constraints.offset(
            horizontal = -occupiedSpaceHorizontally,
            vertical = -bottomPadding - topPadding
        ).copy(minHeight = 0)
        val textFieldPlaceable =
            measurables.first { it.layoutId == TextFieldId }.measure(textConstraints)

        // measure placeholder
        val placeholderConstraints = textConstraints.copy(minWidth = 0)
        val placeholderPlaceable =
            measurables.find { it.layoutId == PlaceholderId }?.measure(placeholderConstraints)

        occupiedSpaceVertically = max(
            occupiedSpaceVertically,
            max(heightOrZero(textFieldPlaceable), heightOrZero(placeholderPlaceable)) +
                    topPadding + bottomPadding
        )

        // measure supporting text
        val supportingConstraints = relaxedConstraints.offset(
            vertical = -occupiedSpaceVertically
        ).copy(minHeight = 0)
        val supportingPlaceable =
            measurables.find { it.layoutId == SupportingId }?.measure(supportingConstraints)
        val supportingHeight = heightOrZero(supportingPlaceable)

        val width =
            calculateWidth(
                leadingPlaceableWidth = widthOrZero(leadingPlaceable),
                trailingPlaceableWidth = widthOrZero(trailingPlaceable),
                prefixPlaceableWidth = widthOrZero(prefixPlaceable),
                suffixPlaceableWidth = widthOrZero(suffixPlaceable),
                textFieldPlaceableWidth = textFieldPlaceable.width,
                labelPlaceableWidth = widthOrZero(labelPlaceable),
                placeholderPlaceableWidth = widthOrZero(placeholderPlaceable),
                isLabelInMiddleSection = isLabelInMiddleSection,
                constraints = constraints,
                density = density,
                paddingValues = paddingValues,
            )
        val totalHeight =
            calculateHeight(
                leadingPlaceableHeight = heightOrZero(leadingPlaceable),
                trailingPlaceableHeight = heightOrZero(trailingPlaceable),
                prefixPlaceableHeight = heightOrZero(prefixPlaceable),
                suffixPlaceableHeight = heightOrZero(suffixPlaceable),
                textFieldPlaceableHeight = textFieldPlaceable.height,
                labelPlaceableHeight = heightOrZero(labelPlaceable),
                placeholderPlaceableHeight = heightOrZero(placeholderPlaceable),
                supportingPlaceableHeight = heightOrZero(supportingPlaceable),
                constraints = constraints,
                density = density,
                paddingValues = paddingValues,
            )
        val height = totalHeight - supportingHeight

        val containerPlaceable = measurables.first { it.layoutId == ContainerId }.measure(
            Constraints(
                minWidth = if (width != Constraints.Infinity) width else 0,
                maxWidth = width,
                minHeight = if (height != Constraints.Infinity) height else 0,
                maxHeight = height
            )
        )
        return layout(width, totalHeight) {
            place(
                totalHeight = totalHeight,
                width = width,
                leadingPlaceable = leadingPlaceable,
                trailingPlaceable = trailingPlaceable,
                prefixPlaceable = prefixPlaceable,
                suffixPlaceable = suffixPlaceable,
                textFieldPlaceable = textFieldPlaceable,
                labelPlaceable = labelPlaceable,
                placeholderPlaceable = placeholderPlaceable,
                containerPlaceable = containerPlaceable,
                supportingPlaceable = supportingPlaceable,
                animationProgress = animationProgress,
                singleLine = singleLine,
                density = density,
                layoutDirection = layoutDirection,
                paddingValues = paddingValues,
            )
        }
    }

    override fun IntrinsicMeasureScope.maxIntrinsicHeight(
        measurables: List<IntrinsicMeasurable>,
        width: Int
    ): Int {
        return intrinsicHeight(measurables, width) { intrinsicMeasurable, w ->
            intrinsicMeasurable.maxIntrinsicHeight(w)
        }
    }

    override fun IntrinsicMeasureScope.minIntrinsicHeight(
        measurables: List<IntrinsicMeasurable>,
        width: Int
    ): Int {
        return intrinsicHeight(measurables, width) { intrinsicMeasurable, w ->
            intrinsicMeasurable.minIntrinsicHeight(w)
        }
    }

    override fun IntrinsicMeasureScope.maxIntrinsicWidth(
        measurables: List<IntrinsicMeasurable>,
        height: Int
    ): Int {
        return intrinsicWidth(measurables, height) { intrinsicMeasurable, h ->
            intrinsicMeasurable.maxIntrinsicWidth(h)
        }
    }

    override fun IntrinsicMeasureScope.minIntrinsicWidth(
        measurables: List<IntrinsicMeasurable>,
        height: Int
    ): Int {
        return intrinsicWidth(measurables, height) { intrinsicMeasurable, h ->
            intrinsicMeasurable.minIntrinsicWidth(h)
        }
    }

    private fun IntrinsicMeasureScope.intrinsicWidth(
        measurables: List<IntrinsicMeasurable>,
        height: Int,
        intrinsicMeasurer: (IntrinsicMeasurable, Int) -> Int
    ): Int {
        val textFieldWidth =
            intrinsicMeasurer(measurables.first { it.layoutId == TextFieldId }, height)
        val labelWidth = measurables.find { it.layoutId == LabelId }?.let {
            intrinsicMeasurer(it, height)
        } ?: 0
        val trailingWidth = measurables.find { it.layoutId == TrailingId }?.let {
            intrinsicMeasurer(it, height)
        } ?: 0
        val leadingWidth = measurables.find { it.layoutId == LeadingId }?.let {
            intrinsicMeasurer(it, height)
        } ?: 0
        val prefixWidth = measurables.find { it.layoutId == PrefixId }?.let {
            intrinsicMeasurer(it, height)
        } ?: 0
        val suffixWidth = measurables.find { it.layoutId == SuffixId }?.let {
            intrinsicMeasurer(it, height)
        } ?: 0
        val placeholderWidth = measurables.find { it.layoutId == PlaceholderId }?.let {
            intrinsicMeasurer(it, height)
        } ?: 0
        return calculateWidth(
            leadingPlaceableWidth = leadingWidth,
            trailingPlaceableWidth = trailingWidth,
            prefixPlaceableWidth = prefixWidth,
            suffixPlaceableWidth = suffixWidth,
            textFieldPlaceableWidth = textFieldWidth,
            labelPlaceableWidth = labelWidth,
            placeholderPlaceableWidth = placeholderWidth,
            isLabelInMiddleSection = animationProgress < 1f,
            constraints = ZeroConstraints,
            density = density,
            paddingValues = paddingValues,
        )
    }

    private fun IntrinsicMeasureScope.intrinsicHeight(
        measurables: List<IntrinsicMeasurable>,
        width: Int,
        intrinsicMeasurer: (IntrinsicMeasurable, Int) -> Int
    ): Int {
        val textFieldHeight =
            intrinsicMeasurer(measurables.first { it.layoutId == TextFieldId }, width)
        val labelHeight = measurables.find { it.layoutId == LabelId }?.let {
            intrinsicMeasurer(it, width)
        } ?: 0
        val trailingHeight = measurables.find { it.layoutId == TrailingId }?.let {
            intrinsicMeasurer(it, width)
        } ?: 0
        val leadingHeight = measurables.find { it.layoutId == LeadingId }?.let {
            intrinsicMeasurer(it, width)
        } ?: 0
        val prefixHeight = measurables.find { it.layoutId == PrefixId }?.let {
            intrinsicMeasurer(it, width)
        } ?: 0
        val suffixHeight = measurables.find { it.layoutId == SuffixId }?.let {
            intrinsicMeasurer(it, width)
        } ?: 0
        val placeholderHeight = measurables.find { it.layoutId == PlaceholderId }?.let {
            intrinsicMeasurer(it, width)
        } ?: 0
        val supportingHeight = measurables.find { it.layoutId == SupportingId }?.let {
            intrinsicMeasurer(it, width)
        } ?: 0
        return calculateHeight(
            leadingPlaceableHeight = leadingHeight,
            trailingPlaceableHeight = trailingHeight,
            prefixPlaceableHeight = prefixHeight,
            suffixPlaceableHeight = suffixHeight,
            textFieldPlaceableHeight = textFieldHeight,
            labelPlaceableHeight = labelHeight,
            placeholderPlaceableHeight = placeholderHeight,
            supportingPlaceableHeight = supportingHeight,
            constraints = ZeroConstraints,
            density = density,
            paddingValues = paddingValues
        )
    }
}

/**
 * Calculate the width of the [OutlinedTextField] given all elements that should be placed inside.
 */
private fun calculateWidth(
    leadingPlaceableWidth: Int,
    trailingPlaceableWidth: Int,
    prefixPlaceableWidth: Int,
    suffixPlaceableWidth: Int,
    textFieldPlaceableWidth: Int,
    labelPlaceableWidth: Int,
    placeholderPlaceableWidth: Int,
    isLabelInMiddleSection: Boolean,
    constraints: Constraints,
    density: Float,
    paddingValues: PaddingValues,
): Int {
    val affixTotalWidth = prefixPlaceableWidth + suffixPlaceableWidth
    val middleSection = maxOf(
        textFieldPlaceableWidth + affixTotalWidth,
        placeholderPlaceableWidth + affixTotalWidth,
        // Prefix/suffix does not get applied to label
        if (isLabelInMiddleSection) labelPlaceableWidth else 0,
    )
    val wrappedWidth =
        leadingPlaceableWidth + middleSection + trailingPlaceableWidth
    val focusedLabelWidth =
        if (!isLabelInMiddleSection) {
            // Actual LayoutDirection doesn't matter; we only need the sum
            val labelHorizontalPadding = (paddingValues.calculateLeftPadding(LayoutDirection.Ltr) +
                    paddingValues.calculateRightPadding(LayoutDirection.Ltr)).value * density
            labelPlaceableWidth + labelHorizontalPadding.roundToInt()
        } else {
            0
        }
    return maxOf(wrappedWidth, focusedLabelWidth, constraints.minWidth)
}

/**
 * Calculate the height of the [OutlinedTextField] given all elements that should be placed inside.
 * This includes the supporting text, if it exists, even though this element is not "visually"
 * inside the text field.
 */
private fun calculateHeight(
    leadingPlaceableHeight: Int,
    trailingPlaceableHeight: Int,
    prefixPlaceableHeight: Int,
    suffixPlaceableHeight: Int,
    textFieldPlaceableHeight: Int,
    labelPlaceableHeight: Int,
    placeholderPlaceableHeight: Int,
    supportingPlaceableHeight: Int,
    constraints: Constraints,
    density: Float,
    paddingValues: PaddingValues
): Int {
    // middle section is defined as a height of the text field or placeholder (whichever is
    // taller) plus spacerSize or half height of the label if it is taller, given that the label
    // is vertically centered to the top edge of the resulting text field's container
    val inputFieldHeight = max(
        textFieldPlaceableHeight,
        placeholderPlaceableHeight
    )
    val topPadding = paddingValues.calculateTopPadding().value * density
    val bottomPadding = paddingValues.calculateBottomPadding().value * density
    val middleSectionHeight = inputFieldHeight + bottomPadding + max(
        topPadding,
        labelPlaceableHeight / 2f
    )
    return max(
        constraints.minHeight,
        maxOf(
            leadingPlaceableHeight,
            trailingPlaceableHeight,
            prefixPlaceableHeight,
            suffixPlaceableHeight,
            middleSectionHeight.roundToInt()
        ) + supportingPlaceableHeight
    )
}

/**
 * Places the provided text field, placeholder, label, optional leading and trailing icons inside
 * the [OutlinedTextField]
 */
private fun Placeable.PlacementScope.place(
    totalHeight: Int,
    width: Int,
    leadingPlaceable: Placeable?,
    trailingPlaceable: Placeable?,
    prefixPlaceable: Placeable?,
    suffixPlaceable: Placeable?,
    textFieldPlaceable: Placeable,
    labelPlaceable: Placeable?,
    placeholderPlaceable: Placeable?,
    containerPlaceable: Placeable,
    supportingPlaceable: Placeable?,
    animationProgress: Float,
    singleLine: Boolean,
    density: Float,
    layoutDirection: LayoutDirection,
    paddingValues: PaddingValues
) {
    // place container
    containerPlaceable.place(IntOffset.Zero)

    // Most elements should be positioned w.r.t the text field's "visual" height, i.e., excluding
    // the supporting text on bottom
    val height = totalHeight - heightOrZero(supportingPlaceable)
    val topPadding = (paddingValues.calculateTopPadding().value * density).roundToInt()
    val startPadding =
        (paddingValues.calculateStartPadding(layoutDirection).value * density).roundToInt()

    val iconPadding = HorizontalIconPadding.value * density

    // placed center vertically and to the start edge horizontally
    leadingPlaceable?.placeRelative(
        0,
        Alignment.CenterVertically.align(leadingPlaceable.height, height)
    )

    // placed center vertically and to the end edge horizontally
    trailingPlaceable?.placeRelative(
        width - trailingPlaceable.width,
        Alignment.CenterVertically.align(trailingPlaceable.height, height)
    )

    // label position is animated
    // in single line text field, label is centered vertically before animation starts
    labelPlaceable?.let {
        val startPositionY = if (singleLine) {
            Alignment.CenterVertically.align(it.height, height)
        } else {
            topPadding
        }
        val positionY = lerp(startPositionY, -(it.height / 2), animationProgress)
        val positionX = (
                if (leadingPlaceable == null) {
                    0f
                } else {
                    (widthOrZero(leadingPlaceable) - iconPadding) * (1 - animationProgress)
                }
                ).roundToInt() + startPadding
        it.placeRelative(positionX, positionY)
    }

    // Single line text fields have text components centered vertically.
    // Multiline text fields have text components aligned to top with padding.
    fun calculateVerticalPosition(placeable: Placeable): Int =
        max(
            if (singleLine) {
                Alignment.CenterVertically.align(placeable.height, height)
            } else {
                topPadding
            },
            heightOrZero(labelPlaceable) / 2
        )

    prefixPlaceable?.placeRelative(
        widthOrZero(leadingPlaceable),
        calculateVerticalPosition(prefixPlaceable)
    )

    suffixPlaceable?.placeRelative(
        width - widthOrZero(trailingPlaceable) - suffixPlaceable.width,
        calculateVerticalPosition(suffixPlaceable)
    )

    val textHorizontalPosition = widthOrZero(leadingPlaceable) + widthOrZero(prefixPlaceable)

    textFieldPlaceable.placeRelative(
        textHorizontalPosition,
        calculateVerticalPosition(textFieldPlaceable)
    )

    // placed similar to the input text above
    placeholderPlaceable?.placeRelative(
        textHorizontalPosition,
        calculateVerticalPosition(placeholderPlaceable)
    )

    // place supporting text
    supportingPlaceable?.placeRelative(0, height)
}

private fun lerp(start: Int, stop: Int, fraction: Float): Int {
    return start + ((stop - start) * fraction.toDouble()).roundToInt()
}