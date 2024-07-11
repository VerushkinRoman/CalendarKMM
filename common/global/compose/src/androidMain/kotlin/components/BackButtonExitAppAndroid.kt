package components

import android.content.Context
import android.content.ContextWrapper
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import dev.icerock.moko.resources.desc.desc
import resources.MR
import kotlin.system.exitProcess

@Composable
actual fun BackButtonExitApp(enabled: () -> Boolean) {
    val context = LocalContext.current

    var lastTimeBackPressed = remember { 0L }

    var isBackShown = remember { false }

    BackHandler(enabled()) {
        if (System.currentTimeMillis() - lastTimeBackPressed < BACK_BUTTON_EXIT_DELAY && isBackShown) {
            context.getActivity()?.finishAndRemoveTask() ?: exitProcess(0)
            return@BackHandler
        } else isBackShown = false
        Toast
            .makeText(
                context,
                MR.strings.back_again_to_exit.desc().toString(context),
                Toast.LENGTH_SHORT
            )
            .show()
        isBackShown = true
        lastTimeBackPressed = System.currentTimeMillis()
    }
}

private const val BACK_BUTTON_EXIT_DELAY = 3000

private fun Context.getActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}
