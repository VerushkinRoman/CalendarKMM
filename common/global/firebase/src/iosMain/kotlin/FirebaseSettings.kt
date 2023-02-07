import dev.gitlive.firebase.firestore.FirebaseFirestore

internal actual class FirebaseSettings actual constructor() {
    actual fun setFirebaseSettings(fireStore: FirebaseFirestore) = Unit
}