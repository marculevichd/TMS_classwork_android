package com.example.tms_classwork_android.presentation.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_classwork_android.presentation.fragments.ItemsFragment


class DetailsViewModel : ViewModel() {


    private val _bundleDetails = MutableLiveData<NavBundle>()
    val bundleDetails: LiveData<NavBundle> = _bundleDetails


    fun getInfo(safeBundle: Bundle) {
        _bundleDetails.value = NavBundle(
            name = safeBundle.getString(ItemsFragment.NAME).toString(),
            date = safeBundle.getString(ItemsFragment.DATE).toString()
        )

    }
}

data class NavBundle(
    val name: String,
    val date: String

)
