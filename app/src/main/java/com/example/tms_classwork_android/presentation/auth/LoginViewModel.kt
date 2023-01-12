package com.example.tms_classwork_android.presentation.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {


    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun loginUser(userName: String, userPassword: String) {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler", "coroutineExceptionHandler")
        }

        viewModelScope.launch(CoroutineName("with exception") + coroutineExceptionHandler + Dispatchers.Main) {
            try {
                launch {
                    authInteractor.loginUser(userName, userPassword)
                    _nav.value = R.id.action_loginFragment_to_homeFragment // postValue используется на других потоках (не Main) }
                }

            } catch (e: Exception) {
                Log.w("exception", "loginUser FAILED")
            }


        }
    }

    fun userNavigated(){
        _nav.value= null
    }


}