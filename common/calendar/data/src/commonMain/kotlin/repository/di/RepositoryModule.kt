package repository.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import repository.DatesRepository
import repository.DatesRepositoryImpl

val repositoryModule = DI.Module("dataRepositoryModule") {
    bind<DatesRepository>() with provider {
        DatesRepositoryImpl(
            firestore = instance(),
            firestoreRepository = instance(),
            coroutinesDispatchers = instance()
        )
    }
}