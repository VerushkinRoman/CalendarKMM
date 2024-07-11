package di

import domain.CoroutinesDispatchers
import domain.CoroutinesDispatchersImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val utilsModule = DI.Module("utilsModule") {
    bind<CoroutinesDispatchers>() with singleton { CoroutinesDispatchersImpl() }
}