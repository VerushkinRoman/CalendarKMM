package navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import ru.alexgladkov.odyssey.compose.RootController
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.configuration.DefaultModalConfiguration
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import theme.AppTheme
import theme.MaterialTheme

@Composable
fun SetupNavigation(
    platformSetup: ((RootController) -> Unit)?
) {
    val rootController = remember { RootComposeBuilder().apply { generateGraph() }.build() }

    LaunchedEffect(true) {
        platformSetup?.invoke(rootController)
        rootController.setupWithViewModels()
    }

    AppTheme {
        val backgroundColor = MaterialTheme.colorScheme.background
        rootController.backgroundColor = backgroundColor

        CompositionLocalProvider(
            LocalRootController provides rootController
        ) {
            ModalNavigator(
                configuration = DefaultModalConfiguration(
                    backgroundColor = backgroundColor,
                    displayType = DisplayType.FullScreen
                )
            ) {
                Navigator(startScreen = NavigationTree.MainFlow.SplashScreen.name)
            }
        }
    }
}