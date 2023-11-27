package com.example.mootapplication.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mootapplication.data.entities.RegisterUser
import kotlinx.coroutines.flow.Flow
@Dao
interface RegisterDao {
    @Query("SELECT * FROM registerUser")
    fun getAllUsers(): Flow<List<RegisterUser>>

}
