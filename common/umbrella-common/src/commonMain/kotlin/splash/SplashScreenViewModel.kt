package splash

import splash.model.SplashScreenAction
import splash.model.SplashScreenEvent
import splash.model.SplashScreenState
import viewModel.BaseSharedViewModel

class SplashScreenViewModel : BaseSharedViewModel<
        SplashScreenState,
        SplashScreenAction,
        SplashScreenEvent>(
    initialState = SplashScreenState()
) {
    init {
        withViewModelScope {
            viewAction = SplashScreenAction.OpenMainScreen
        }
    }

    override fun obtainEvent(viewEvent: SplashScreenEvent) {
        when (viewEvent) {
            SplashScreenEvent.ClearAction -> viewAction = null
        }
    }
}