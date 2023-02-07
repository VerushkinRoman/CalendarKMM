import model.User

interface AccountRepository {
    suspend fun getMyEmailOrId(): String?
    fun getCurrentUser(): User?
}