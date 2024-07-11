package splash

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import splash.model.SplashScreenAction
import splash.model.SplashScreenEvent

@Composable
internal fun SplashScreen(
    modifier: Modifier = Modifier,
    viewAction: () -> SplashScreenAction?,
    obtainEvent: (SplashScreenEvent) -> Unit,
    navigateToMainScreen: () -> Unit,
) {
    viewAction()?.let { action ->
        when (action) {
            is SplashScreenAction.OpenMainScreen -> navigateToMainScreen()
        }
        obtainEvent(SplashScreenEvent.ClearAction)
    }

    Box(modifier = modifier)
}