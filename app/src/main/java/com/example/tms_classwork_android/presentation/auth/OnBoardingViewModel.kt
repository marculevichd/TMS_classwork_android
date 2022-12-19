package com.example.tms_classwork_android.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnBoardingViewModel : ViewModel() {


    val onBoardingText = MutableLiveData<String>("default value")

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun finishButtonClicked() {
        _nav.value = Unit
    }

    fun finishPerformed() {
        _nav.value = null
    }

}