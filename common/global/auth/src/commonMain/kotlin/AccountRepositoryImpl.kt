import model.GoogleAccount
import model.User
import com.russhwolf.settings.Settings
import dev.gitlive.firebase.auth.FirebaseAuth

class AccountRepositoryImpl(
    private var googleAccount: GoogleAccount,
    private val settings: Settings,
    private val firebaseAuth: FirebaseAuth
) : AccountRepository {

    override suspend fun getMyEmailOrId(): String? {
        return googleAccount.getEmail()
            ?: firebaseAuth.currentUser?.email
            ?: firebaseAuth.currentUser?.uid
            ?: anonymousLogin()
    }

    override fun getCurrentUser(): User? {
        return firebaseAuth.currentUser?.let { account ->
            account.email?.let { mail ->
                User(
                    nickName = settings.getStringOrNull("nickName") ?: mail,
                    email = mail,
                    pictureUrl = account.photoURL
                )
            }
        }
    }

    private suspend fun anonymousLogin(): String? = firebaseAuth
        .signInAnonymously()
        .user
        ?.let { user ->
            user.email ?: user.uid
        }
}