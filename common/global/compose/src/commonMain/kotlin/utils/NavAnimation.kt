package utils

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize

class NavAnimation(val enterTransition: EnterTransition, val exitTransition: ExitTransition)

val forwardNavAnimation = NavAnimation(
    enterTransition = slideIntoContainer(SlideDirection.Left),
    exitTransition = slideOutOfContainer(SlideDirection.Left)
)

val backwardNavAnimation = NavAnimation(
    enterTransition = slideIntoContainer(SlideDirection.Right),
    exitTransition = slideOutOfContainer(SlideDirection.Right)
)

val noTransitionAnimation = NavAnimation(
    enterTransition = EnterTransition.None,
    exitTransition = ExitTransition.None
)

val emptyTransitionAnimation = NavAnimation(
    enterTransition = fadeIn(animationSpec = getStandardAnimation()),
    exitTransition = fadeOut(animationSpec = getStandardAnimation())
)

private fun slideIntoContainer(direction: SlideDirection): EnterTransition {
    return slideIn(
        animationSpec = getStandardAnimation()
    ) { size ->
        calculateOffset(direction, size)
    }
}

private fun slideOutOfContainer(direction: SlideDirection): ExitTransition {
    return slideOut(
        animationSpec = getStandardAnimation()
    ) { size ->
        calculateOffset(direction, size, false)
    }
}

private fun calculateOffset(
    direction: SlideDirection,
    size: IntSize,
    slideIn: Boolean = true
): IntOffset {
    return when (direction) {
        SlideDirection.Right -> IntOffset(x = size.width.let { if (slideIn) -it else it }, y = 0)
        SlideDirection.Left -> IntOffset(x = size.width.let { if (slideIn) it else -it }, y = 0)
        SlideDirection.Up -> IntOffset(x = 0, y = size.height.let { if (slideIn) it else -it })
        SlideDirection.Down -> IntOffset(x = 0, y = size.height.let { if (slideIn) -it else it })
    }
}

private enum class SlideDirection {
    Right, Left, Up, Down
}