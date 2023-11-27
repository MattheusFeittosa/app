package com.example.mootapplication.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "registerUser")
data class RegisterUser(
    @ColumnInfo(name = "name")
    val name: String,
    val userName: String,
    val password: String,
    val picture: String,
    val address: String,
    val email: String,
    val birthDay: String,
    val gender: String,
    val isPersonPhysical: Boolean,
    val cpf: String?,
    val cnpj: String?,
    @PrimaryKey
    val id:Int?,
)