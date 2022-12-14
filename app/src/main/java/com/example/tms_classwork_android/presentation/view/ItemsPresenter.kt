package com.example.tms_classwork_android.presentation.view

import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.domain.ItemsInteractor
import com.example.tms_classwork_android.model.ItemsModel

class ItemsPresenter(
    private val itemsView: ItemsView,
    private val itemsInteractor: ItemsInteractor,
) {


    fun getData() {
        val listItems = itemsInteractor.getData()
        itemsView.dataReceived(listItems)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.iv_clicked)
    }

    fun elementSelected(name: String, date: String, imageView: Int) {
        itemsView.goToDetails(name, date, imageView)
    }
}