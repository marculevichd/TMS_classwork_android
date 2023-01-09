package com.example.tms_classwork_android.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_classwork_android.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {


    private val _userExists = MutableLiveData<Boolean>()
    val userExist: LiveData<Boolean> = _userExists


    fun checkUserExists() {
        viewModelScope.launch {

            try {
                _userExists.value = authInteractor.checkUserExist()
            } catch (e: Exception) {
                Log.w("exception", "checkUserExists FAILED")
            }

        }
    }
}