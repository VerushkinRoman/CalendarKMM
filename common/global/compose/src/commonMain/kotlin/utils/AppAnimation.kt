package utils

import androidx.compose.animation.core.tween

fun <T> getStandardAnimation() = tween<T>(ANIMATION_DURATION)

const val ANIMATION_DURATION = 500