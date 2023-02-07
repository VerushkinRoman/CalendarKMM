package repository

import dev.gitlive.firebase.firestore.DocumentSnapshot
import dev.gitlive.firebase.firestore.FirebaseFirestore
import FirestoreRepository
import model.Documents
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.transform
import model.DayData
import CoroutinesDispatchers
import Resource

class DatesRepositoryImpl(
    private val firestore: FirebaseFirestore,
    private val firestoreRepository: FirestoreRepository,
    private val coroutinesDispatchers: CoroutinesDispatchers
) : DatesRepository {

    override fun getDates(userMail: String): Flow<Resource<List<DayData>>> =
        firestore
            .collection(userMail)
            .document(Documents.Dates.value)
            .snapshots
            .flowOn(coroutinesDispatchers.io)
            .onStart { Resource.Loading(null) }
            .transform {
                try {
                    val result = getResult(it)
                    Resource.Success(result)
                } catch (e: Exception) {
                    Resource.Error()
                }
            }

    override suspend fun changeDate(
        userMail: String,
        day: DayData,
        shouldDelete: Boolean
    ): Boolean {
        return firestoreRepository
            .changeItem(
                collection = userMail,
                document = Documents.Dates.value,
                data = day,
                delete = shouldDelete
            )
    }

    private fun getResult(snapshot: DocumentSnapshot): List<DayData> {
//        return snapshot.get()// TODO
//            .data?.values?.map {
//            @Suppress("UNCHECKED_CAST")
//            (it as Map<String, Any>).toDataClass()
//        } ?:
        return emptyList()
    }
}