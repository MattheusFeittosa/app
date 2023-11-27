import android.content.Context
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterUserRepository @Inject constructor(context: Context) {
    private val userDao = AppDatabase.getInstance(context).userDao()

    fun getAllUsers() = flow {
        emit(userDao.getAllUsers())
    }
}
