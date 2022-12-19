package com.example.tms_classwork_android.domain.items

import com.example.tms_classwork_android.domain.model.ItemsModel
import javax.inject.Inject

class ItemsInteractor @Inject constructor(
    private val itemsRepository: ItemsRepository
) {
    fun getData(): List<ItemsModel> {
        return itemsRepository.getData()
    }
}