package com.example.tms_classwork_android.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_classwork_android.domain.auth.AuthInteractor
import com.example.tms_classwork_android.domain.model.UserModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds: LiveData<UserModel> = _userCreds


    fun showUserData() {

            viewModelScope.launch{
                try {
                _userCreds.value = authInteractor.getUserCreds()
            } catch (e:Exception){
                Log.w("exception", "showUserData FAILED")
            }
        }
    }


}