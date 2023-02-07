package navigation

import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.friendsCalendarFlow() {
    flow(name = NavigationTree.MainFlow.CalendarFlow.name) {
        screen(name = NavigationTree.CalendarFlow.Calendar.name) {
//            CalendarView(isMyCalendar = false)
            Text(
                "Hello",
                color = Color.Green
            )
        }

        screen(name = NavigationTree.CalendarFlow.Friends.name) {

        }
    }
}