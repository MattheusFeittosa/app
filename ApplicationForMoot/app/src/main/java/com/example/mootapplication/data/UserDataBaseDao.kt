import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mootapplication.data.entities.RegisterUser
import com.example.mootapplication.data.repository.RegisterDao

@Database(entities = [RegisterUser::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): RegisterDao

    companion object {
        private const val DATABASE_NAME = "app_database"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}
