package com.example.tms_classwork_android.domain

import com.example.tms_classwork_android.model.ItemsModel

interface ItemsRepository {

    fun getData(): List<ItemsModel>
}