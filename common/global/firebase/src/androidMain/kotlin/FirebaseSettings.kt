import com.google.firebase.firestore.FirebaseFirestoreSettings
import dev.gitlive.firebase.firestore.FirebaseFirestore

internal actual class FirebaseSettings actual constructor() {
    actual fun setFirebaseSettings(fireStore: FirebaseFirestore) {
        fireStore.android.firestoreSettings = FirebaseFirestoreSettings
            .Builder()
            .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED)
            .build()
    }
}