package com.example.tms_classwork_android.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tms_classwork_android.domain.items.ItemsInteractor
import com.example.tms_classwork_android.presentation.viewmodel.ItemsViewModel

class ItemsViewModelsFactory(private val itemsInteractor: ItemsInteractor): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(itemsInteractor) as T
    }

}