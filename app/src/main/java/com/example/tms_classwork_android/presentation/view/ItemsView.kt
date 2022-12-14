package com.example.tms_classwork_android.presentation.view

import com.example.tms_classwork_android.model.ItemsModel

interface ItemsView {

    fun dataReceived(list: List<ItemsModel>)

    fun imageViewClicked(ivClicked: Int)

    fun goToDetails(name: String, date: String, imageView: Int)
}