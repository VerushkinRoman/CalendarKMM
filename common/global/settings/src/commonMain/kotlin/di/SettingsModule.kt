package di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import Settings

internal val settingsModule = DI.Module("settingsModule") {
    bind<com.russhwolf.settings.Settings>() with singleton {
        Settings(instance()).settings
    }
}