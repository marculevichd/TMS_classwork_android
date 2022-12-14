package com.example.tms_classwork_android.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tms_classwork_android.presentation.viewmodel.ItemsViewModel
import com.example.tms_classwork_android.presentation.viewmodel.MyParam

class ItemsViewModelsFactory(private val myParam: MyParam): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(myParam) as T
    }

}