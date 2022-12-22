package com.example.tms_classwork_android.presentation.home

import com.example.tms_classwork_android.domain.model.ItemsModel

interface ItemsView {

    fun itemsReceived(itemsList: List<ItemsModel>)

    fun imageViewClicked(msg: Int)

    fun itemClicked(navigationWithData: NavigateWithBundle)


}