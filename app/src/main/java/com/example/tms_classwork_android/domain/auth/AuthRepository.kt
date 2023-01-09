package com.example.tms_classwork_android.domain.auth

import com.example.tms_classwork_android.domain.model.UserModel

interface AuthRepository {

    suspend fun loginUser(userName:String, userPassword:String)

    suspend fun showUserCreds(): UserModel


    suspend fun doesUserExists():Boolean

    suspend fun userLogout()

}