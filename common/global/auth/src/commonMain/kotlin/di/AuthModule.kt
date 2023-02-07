package di

import AccountRepository
import AccountRepositoryImpl
import model.GoogleAccount
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

internal val authModule = DI.Module("authModule") {
    bind<AccountRepository>() with provider {
        AccountRepositoryImpl(
            googleAccount = GoogleAccount(instance()),
            settings = instance(),
            firebaseAuth = instance()
        )
    }

    bind<FirebaseAuth>() with provider {
        Firebase.auth
    }
}