package com.example.tms_classwork_android.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.domain.auth.AuthInteractor
import com.example.tms_classwork_android.domain.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds: LiveData<UserModel> = _userCreds


    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun showUserData() {
            viewModelScope.launch{
                try {
                _userCreds.value = authInteractor.getUserCreds()
            } catch (e:Exception){
                Log.w("exception", "showUserData FAILED")
            }
        }
    }

    fun navNext() {
        _nav.value = R.navigation.main_graph
    }


}