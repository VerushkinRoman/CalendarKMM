import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun SplashScreen() {
    val rootController = LocalRootController.current

    LaunchedEffect(true) {
        delay(2000)
        rootController.present(NavigationTree.MainFlow.CalendarFlow.name)
    }


}