package di

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.FirebaseFirestore
import dev.gitlive.firebase.firestore.firestore
import FirebaseSettings
import FirestoreRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

internal val firebaseModule = DI.Module("firebaseModule") {
    bind<FirebaseFirestore>() with singleton {
        Firebase.firestore.apply { FirebaseSettings().setFirebaseSettings(this) }
    }

    bind<FirestoreRepository>() with provider {
        FirestoreRepository(instance())
    }
}