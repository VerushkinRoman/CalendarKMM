package splash.model

sealed class SplashScreenEvent {
    data object ClearAction: SplashScreenEvent()
}