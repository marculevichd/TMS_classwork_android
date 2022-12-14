package com.example.tms_classwork_android.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.databinding.ItemFruitBinding
import com.example.tms_classwork_android.presentation.adapter.listener.itemListener
import com.example.tms_classwork_android.model.ItemsModel

class ItemsAdapter(
    private val itemsListener: itemListener
): RecyclerView.Adapter<ItemsViewHolder>() {

    private var listItems = mutableListOf<ItemsModel>()

    fun submitList(list: List<ItemsModel>){
        this.listItems = list.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val viewBinding = ItemFruitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ItemsViewHolder(viewBinding, itemsListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}