package com.example.tms_classwork_android.presentation.home

import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.domain.items.ItemsInteractor
import javax.inject.Inject

class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView

    fun setView(itemsFragment: ItemsFragment) {
        itemsView = itemsFragment
    }


    fun getItems() {
        val items = itemsInteractor.getData()
        itemsView.itemsReceived(items)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.image_view)
    }

    fun itemClicked(name: String, date: String, imageView: Int) {
        itemsView.itemClicked(NavigateWithBundle(imageView,name, date ))
    }
}


data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String,
)