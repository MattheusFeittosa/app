package com.example.mootapplication.models

import java.util.Base64

data class User(
    val name: String,
    val userName:String,
    val password:String,
    val picture:Base64,
    val address:String,
    val email: String,
    val birthDay:String,
    val gender:String,
    val isPersonPhysical: Boolean,
    val cpf: String?,
    val cnpj: String?,
)
