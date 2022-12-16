package com.example.tms_classwork_android.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {


    val userName = MutableLiveData<String>() // вьюмодел только с лайвдатой работает
    val userPassword = MutableLiveData<String>()

    val userCreads = MutableLiveData<String>()

    fun showCreads(){
        userCreads.value="${userName.value.toString()} \n ${userPassword.value.toString()}"
    }


}