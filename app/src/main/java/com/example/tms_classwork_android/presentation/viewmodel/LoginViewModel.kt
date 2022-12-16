package com.example.tms_classwork_android.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val userName = MutableLiveData<String>()
    val userPassword = MutableLiveData<String>()

    val userCreds = MutableLiveData<String>()


    fun showCreds(){
        userCreds.value = "${userName.value.toString()}\n${userPassword.value.toString()}"
    }

}