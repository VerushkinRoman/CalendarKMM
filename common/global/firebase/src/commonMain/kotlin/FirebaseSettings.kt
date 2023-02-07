import dev.gitlive.firebase.firestore.FirebaseFirestore

internal expect class FirebaseSettings constructor() {
    fun setFirebaseSettings(fireStore: FirebaseFirestore)
}