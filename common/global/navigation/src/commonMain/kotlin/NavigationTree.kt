package navigation

object NavigationTree {
    enum class MainFlow {
        SplashScreen, CalendarFlow, FriendsFlow, SettingsFlow
    }

    enum class CalendarFlow {
        Calendar, Friends
    }
}