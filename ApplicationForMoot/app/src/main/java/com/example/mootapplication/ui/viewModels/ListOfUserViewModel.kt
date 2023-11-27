package com.example.mootapplication.ui.viewModels

import RegisterUserRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mootapplication.data.entities.RegisterUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListOfUserViewModel @Inject constructor(val userRepository: RegisterUserRepository): ViewModel() {

    private val listOfUsers = MutableLiveData<List<RegisterUser>>()
    val _listOfUsers: LiveData<List<RegisterUser>> = listOfUsers

    fun getListOfUsers() {
        viewModelScope.launch {
            try {
                val users = userRepository.getAllUsers()
            } catch (e: Exception) {
                // Lidar com exceções, se necessário
            }
        }
    }
}
