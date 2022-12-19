package com.example.tms_classwork_android.data.auth

import com.example.tms_classwork_android.data.shedpref.SharedPreferencesHelper
import com.example.tms_classwork_android.domain.auth.AuthRepository
import com.example.tms_classwork_android.domain.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : AuthRepository {
    override fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)
    }

    override fun showUserCreds(): UserModel {
        return sharedPreferencesHelper.getUserCreds()
    }

    override fun doesUserExists(): Boolean {
        return sharedPreferencesHelper.checkUserExist()
    }

    override fun userLogout() {
        sharedPreferencesHelper.removeUser()
    }
}