package navigation

import SplashScreen
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.generateGraph() {
    screen(name = NavigationTree.MainFlow.SplashScreen.name) {
        SplashScreen()
    }

    friendsCalendarFlow()
}