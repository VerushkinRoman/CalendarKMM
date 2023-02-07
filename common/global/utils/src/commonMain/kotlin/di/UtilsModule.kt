package di

import org.kodein.di.DI

val utilsModule = DI.Module("utilsModule") {
    importAll(
        coroutinesModule
    )
}