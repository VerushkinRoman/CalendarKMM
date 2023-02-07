import di.Inject
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.singleton
import platform.PlatformConfiguration

object PlatformComposeSDK {

    fun init(configuration: PlatformConfiguration) {
        val umbrellaComposeModule = DI.Module("umbrellaComposeModule") {
            bind<PlatformConfiguration>() with singleton { configuration }
        }

        Inject.createDependencies(
            DI {
                importAll(
                    umbrellaComposeModule
                )
            }.direct
        )
    }
}