package com.example.tms_classwork_android.presentation.home

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
class DetailsViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private var _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun logoutUser() {
        viewModelScope.launch {

            try {
                authInteractor.logoutUser()
                _nav.value = Unit
            } catch (e:Exception){
                Log.w("exception", "logoutUser FAILED")
            }

        }
    }

}