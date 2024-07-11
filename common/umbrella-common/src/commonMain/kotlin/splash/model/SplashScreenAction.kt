package splash.model

sealed class SplashScreenAction {
    data object OpenMainScreen : SplashScreenAction()
}