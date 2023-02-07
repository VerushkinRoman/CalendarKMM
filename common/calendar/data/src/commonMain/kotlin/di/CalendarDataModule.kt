package di

import org.kodein.di.DI
import repository.di.repositoryModule

val calendarApiModule = DI.Module("calendarDataModule"){
    importAll(
        repositoryModule
    )
}