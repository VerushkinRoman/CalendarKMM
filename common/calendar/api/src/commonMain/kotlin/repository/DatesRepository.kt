package repository

import kotlinx.coroutines.flow.Flow
import model.DayData
import Resource

interface DatesRepository {
    fun getDates(userMail: String): Flow<Resource<List<DayData>>>
    suspend fun changeDate(userMail: String, day: DayData, shouldDelete: Boolean): Boolean
}