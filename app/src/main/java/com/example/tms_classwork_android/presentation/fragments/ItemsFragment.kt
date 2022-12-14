package com.example.tms_classwork_android.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_classwork_android.utils.BundleConstants.IMAGE_VIEW
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.presentation.adapter.ItemsAdapter
import com.example.tms_classwork_android.domain.listener.itemListener
import com.example.tms_classwork_android.presentation.factory.ItemsViewModelsFactory
import com.example.tms_classwork_android.presentation.viewmodel.ItemsViewModel
import com.example.tms_classwork_android.presentation.viewmodel.MyParam


class ItemsFragment : Fragment(), itemListener {

    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel: ItemsViewModel by viewModels {
        ItemsViewModelsFactory(MyParam())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)//requireContext() или requireActivity()
        recyclerView.adapter = itemsAdapter

        viewModel.getData()

        viewModel.items.observe(viewLifecycleOwner){ listItems -> //получаем данные из viewModel
            itemsAdapter.submitList(listItems)
        }

        viewModel.msg.observe(viewLifecycleOwner){ msg ->
            //getString(msg) обязательно, чтобы наш ресурс преобразовать в строку
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

        viewModel.bundle.observe(viewLifecycleOwner){navBundle ->
            if(navBundle != null) {
                val detailsFragment = DetailsFragment()
                val bundle = Bundle()
                bundle.putString(NAME, navBundle.name)
                bundle.putString(DATE, navBundle.date)
                bundle.putInt(IMAGE_VIEW, navBundle.image)
                detailsFragment.arguments = bundle

                Toast.makeText(context, "called", Toast.LENGTH_SHORT).show()

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, detailsFragment)
                    //.add(R.id.activity_container, detailsFragment)
                    .addToBackStack("Details")
                    .commit()
                //в конец нашего действия
                viewModel.userNavigated()
            }
        }
    }

    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }

    //2 способ создания констант (можно использовать потому что мы видим откуда берём)
    companion object{
        const val DATE = "date"
        const val NAME = "name"
    }
}