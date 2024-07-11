import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

object UiConstants {
    val spacerSize @Composable get() = 16.dp
    val commonButtonHeight @Composable get() = ButtonDefaults.MinHeight
    val commonButtonShape @Composable get() = CircleShape
    val navigationIconSize @Composable get() = commonButtonHeight


    val calendarMinimalPaddings: PaddingValues
        get() = PaddingValues(
            start = 2.dp,
            top = 2.dp,
            end = 2.dp,
            bottom = 2.dp
        )
}