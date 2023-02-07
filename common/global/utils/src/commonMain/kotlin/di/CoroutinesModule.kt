package di

import CoroutinesDispatchers
import CoroutinesDispatchersImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

internal val coroutinesModule = DI.Module("coroutinesModule") {
    bind<CoroutinesDispatchers>() with singleton {
        CoroutinesDispatchersImpl()
    }
}