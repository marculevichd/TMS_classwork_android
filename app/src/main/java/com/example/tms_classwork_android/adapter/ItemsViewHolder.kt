package com.example.tms_classwork_android.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.listener.itemListener
import com.example.tms_classwork_android.model.ItemsModel

class ItemsViewHolder(
    private val view: View,
    private val itemsListener: itemListener,
) : RecyclerView.ViewHolder(view) {

    fun bind(itemsModel: ItemsModel) {
        val name = view.findViewById<TextView>(R.id.tv_name)
        val imageView = view.findViewById<ImageView>(R.id.image)
        val date = view.findViewById<TextView>(R.id.tv_date)

        name.text = itemsModel.name
        imageView.setBackgroundResource(itemsModel.image)
        date.text = itemsModel.date

        imageView.setOnClickListener {
            itemsListener.onClick()
        }

        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsModel.name,
                itemsModel.date,
                itemsModel.image,
            )
        }
    }
}