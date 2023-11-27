import android.app.Application
import android.content.Context
import com.example.mootapplication.ui.viewModels.ListOfUserViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    fun provideRegisterUserRepository(application: Application): RegisterUserRepository {
        return RegisterUserRepository(application.applicationContext)
    }

    @Provides
    fun provideListOfUsersViewModel(repository: RegisterUserRepository): ListOfUserViewModel {
        return ListOfUserViewModel(repository)
    }
}