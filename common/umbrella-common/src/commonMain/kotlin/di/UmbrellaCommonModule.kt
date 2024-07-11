package di

import org.kodein.di.DI

internal val umbrellaCommonModule = DI.Module("umbrellaCommonModule") {
    importAll(
        utilsModule,
    )
}