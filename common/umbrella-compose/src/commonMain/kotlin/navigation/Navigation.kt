package navigation

//import dev.icerock.moko.permissions.compose.BindEffect
//import dev.icerock.moko.permissions.compose.PermissionsControllerFactory
//import dev.icerock.moko.permissions.compose.rememberPermissionsControllerFactory
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import components.BackButtonExitApp
import domain.MultipleEventsCutter
import domain.get
import splash.SplashScreen
import splash.SplashScreenViewModel
import utils.ANIMATION_DURATION
import utils.emptyTransitionAnimation
import utils.noTransitionAnimation
import viewModel.collectAsStateWithLifecycle

@Composable
internal fun Navigation() {
    val navController = rememberNavController()

    var currentRoute by remember { mutableStateOf<String?>(null) }
    var previousRoute by remember { mutableStateOf<String?>(null) }

    val multipleEventsCutter = remember { MultipleEventsCutter.get(ANIMATION_DURATION + 200L) }

    LaunchedEffect(navController) {
        navController.currentBackStack.collect {
            val current = it.lastOrNull()?.destination?.route
            previousRoute = currentRoute
            currentRoute = current
        }
    }

    NavHost(
        navController = navController,
        startDestination =  NavigationTree.MainFlow.SplashScreen.name,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(
            route = NavigationTree.MainFlow.SplashScreen.name,
            enterTransition = { noTransitionAnimation.enterTransition },
            exitTransition = { noTransitionAnimation.exitTransition },
        ) {
            val viewModel = viewModel { SplashScreenViewModel() }
            val splashAction by viewModel.viewActions().collectAsStateWithLifecycle()

            SplashScreen(
                viewAction = { splashAction },
                obtainEvent = viewModel::obtainEvent,
                navigateToMainScreen = remember {
                    {
                        multipleEventsCutter.processEvent {
                            navController.navigate(NavigationTree.MainFlow.Main.name)
                        }
                    }
                },
                modifier = Modifier.fillMaxSize()
            )
        }

        composable(
            route = NavigationTree.MainFlow.Main.name,
            enterTransition = { emptyTransitionAnimation.enterTransition },
            exitTransition = { emptyTransitionAnimation.exitTransition },
        ) {
            Box(modifier = Modifier.fillMaxSize()){
                Text(text = "Main flow")
            }
////            val factory: PermissionsControllerFactory = rememberPermissionsControllerFactory()
//            val viewModel = viewModel {
////                AccountNavigationViewModel(permissionsController = factory.createPermissionsController())
//                AccountNavigationViewModel()
//            }
//            val state by viewModel.viewStates().collectAsState()
//            val splashAction by viewModel.viewActions().collectAsStateWithLifecycle()
//
////            BindEffect(viewModel.permissionsController)
//
//            AccountNavigationScreen(
//                state = { state },
//                viewAction = { splashAction },
//                obtainEvent = viewModel::obtainEvent,
//                logout = remember {
//                    {
//                        multipleEventsCutter.processEvent {
//                            navController.navigate(
//                                route = NavigationTree.MainFlow.AuthFlow.name,
//                                navOptions = NavOptions.Builder().setLaunchSingleTop(true).build(),
//                            )
//                        }
//                    }
//                }
//            )
        }
    }

    BackButtonExitApp()
}