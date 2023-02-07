import dev.gitlive.firebase.firestore.FieldValue
import dev.gitlive.firebase.firestore.FirebaseFirestore

class FirestoreRepository (private val firestore: FirebaseFirestore) {
    suspend fun <T> changeItem(collection: String, document: String, data: T, delete: Boolean): Boolean {
        return try {
            val documentToChange = firestore
                .collection(collection)
                .document(document)

            val value: Any? = if (delete) FieldValue.delete else data

            documentToChange.set(mapOf(Pair(data.toString(), value)), merge = true)
            true
        } catch (e: Exception) {
            false
        }
    }
}