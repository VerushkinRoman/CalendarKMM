package repository

import domain.Resource
import kotlinx.coroutines.flow.Flow
import model.DayData

interface DatesRepository {
    fun getDates(userMail: String): Flow<Resource<List<DayData>>>
    suspend fun changeDate(userMail: String, day: DayData, shouldDelete: Boolean): Boolean
}