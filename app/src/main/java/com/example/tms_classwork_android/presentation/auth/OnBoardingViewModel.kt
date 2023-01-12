package com.example.tms_classwork_android.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_classwork_android.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor() : ViewModel() {


    val onBoardingText = MutableLiveData<String>("default value")

    private val _nav = MutableLiveData<NavToItems?>()
    val nav: LiveData<NavToItems?> = _nav

    fun finishButtonClicked() {
        _nav.value = NavToItems(R.id.action_onBoardingFragment_to_itemsFragment, R.id.onBoardingFragment)
    }

    fun finishPerformed() {
        _nav.value = null
    }

}

data class NavToItems (val destinationId: Int, val removeFragmentId: Int)
