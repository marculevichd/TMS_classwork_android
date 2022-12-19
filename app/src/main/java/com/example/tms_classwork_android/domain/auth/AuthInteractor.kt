package com.example.tms_classwork_android.domain.auth

import com.example.tms_classwork_android.domain.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {
    fun loginUser(userName: String, userPassword: String) {
        authRepository.loginUser(userName, userPassword)
    }

    fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    fun checkUserExist(): Boolean {
        return authRepository.doesUserExists()
    }

    fun logoutUser() {
        authRepository.userLogout()
    }


}