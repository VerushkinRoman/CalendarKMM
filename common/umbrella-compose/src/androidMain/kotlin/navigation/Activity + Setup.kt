package navigation

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity

fun ComponentActivity.setupThemedNavigation(){
    setContent {
        SetupNavigation {rootController ->
            rootController.setupWithActivity(this)
        }
    }
}