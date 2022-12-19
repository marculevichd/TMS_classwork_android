package com.example.tms_classwork_android.domain.auth

import com.example.tms_classwork_android.domain.model.UserModel

interface AuthRepository {

    fun loginUser(userName:String, userPassword:String)

    fun showUserCreds(): UserModel


    fun doesUserExists():Boolean

    fun userLogout()

}