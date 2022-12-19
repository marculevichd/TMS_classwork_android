package com.example.tms_classwork_android.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_classwork_android.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {


    private val _userExists = MutableLiveData<Boolean>()
    val userExist: LiveData<Boolean> = _userExists


    fun checkUserExists() {
        _userExists.value = authInteractor.checkUserExist()
    }
}