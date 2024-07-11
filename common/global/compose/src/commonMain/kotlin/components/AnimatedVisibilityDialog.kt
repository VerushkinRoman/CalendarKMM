package components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import utils.ANIMATION_DURATION
import utils.emptyTransitionAnimation

@Composable
fun <T> AnimatedVisibilityDialog(
    dialogData: T,
    enterTransition: EnterTransition = emptyTransitionAnimation.enterTransition,
    exitTransition: ExitTransition = emptyTransitionAnimation.exitTransition,
    dialog: @Composable (T?) -> Unit
) {
    var visibleData: T? by remember { mutableStateOf(null) }

    LaunchedEffect(dialogData) {
        if (dialogData == visibleData) return@LaunchedEffect
        if (dialogData == null) delay(ANIMATION_DURATION.toLong())
        visibleData = dialogData
    }

    AnimatedVisibility(
        visible = visibleData != null && dialogData != null,
        enter = enterTransition,
        exit = exitTransition
    ) {
        dialog(visibleData)
    }
}