package components

import CalendarTheme
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import utils.emptyTransitionAnimation

@Composable
fun LoadingPlaceholder(
    isShowing: () -> Boolean,
    backgroundColor: Color = CalendarTheme.colorScheme.shadow,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = isShowing(),
        enter = emptyTransitionAnimation.enterTransition,
        exit = emptyTransitionAnimation.exitTransition,
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    enabled = isShowing(),
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {}
                )
                .background(backgroundColor)
        ) {
            SpinningProgressBar()
        }
    }
}