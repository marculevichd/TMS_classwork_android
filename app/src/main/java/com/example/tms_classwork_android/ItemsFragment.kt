package com.example.tms_classwork_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_classwork_android.adapter.ItemsAdapter
import com.example.tms_classwork_android.listener.itemListener
import com.example.tms_classwork_android.model.ItemsModel

class ItemsFragment : Fragment(), itemListener {

    private lateinit var itemsAdapter: ItemsAdapter // private var itemsAdapter: ItemsAdapter = ItemsAdapter() можно так но не нужно

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

        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.android,
                "Android",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.swift,
                "IOS",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.flutter,
                "Flutter",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.pyth,
                "Python",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.cplus,
                "C++",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.c,
                "C",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.ruby,
                "Ruby",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.net,
                ".NET",
                "03.01.2018"
            ),
            ItemsModel(R.drawable.go,
                "Golang",
                "23.12.2030"
            ),
            ItemsModel(R.drawable.php,
                "PHP",
                "23.12.2008"
            ),
            ItemsModel(R.drawable.js,
                "JS",
                "20.09.2006"
            ),
            ItemsModel(R.drawable.fruit,
                "React",
                "23.12.1992"
            )
        )
        itemsAdapter.submitList(listItems)
    }

    override fun onClick() {
        Toast.makeText(context, "ImageView clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {

        val  detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("date", date)
        bundle.putInt("imageView", imageView)
        detailsFragment.arguments = bundle


        // add метод мы больше не испульзуем, теперь мы будем использовать replace
        //replace всегда будет иметь или addToBackstack, чтобы мы могли вернуться назад
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            //.add(R.id.activity_container, detailsFragment)
            .addToBackStack("Details")
            .commit()
    }
}