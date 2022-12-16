package com.example.tms_classwork_android.domain

import com.example.tms_classwork_android.domain.model.ItemsModel

class ItemsInteractor (private val itemsRepository: ItemsRepository) {


    fun getData(): List<ItemsModel> {
        return itemsRepository.getData()
    }

}