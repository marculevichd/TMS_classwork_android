package com.example.tms_classwork_android.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.data.ItemsRepositoryImpl
import com.example.tms_classwork_android.databinding.FragmentItemsBinding
import com.example.tms_classwork_android.databinding.FragmentOnBoardingBinding
import com.example.tms_classwork_android.domain.ItemsInteractor
import com.example.tms_classwork_android.domain.ItemsRepository
import com.example.tms_classwork_android.presentation.adapter.ItemsAdapter
import com.example.tms_classwork_android.presentation.adapter.listener.itemListener
import com.example.tms_classwork_android.model.ItemsModel

class ItemsFragment : Fragment(), itemListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter = ItemsPresenter(this, ItemsInteractor(ItemsRepositoryImpl()))

        itemsAdapter = ItemsAdapter(this)
        viewBinding.recyclerView.adapter = itemsAdapter

        itemsPresenter.getData()
    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()

    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {

        itemsPresenter.elementSelected(name, date, imageView)

    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun goToDetails(name: String, date: String, imageView: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("date", date)
        bundle.putInt("imageView", imageView)
        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            //.add(R.id.activity_container, detailsFragment)
            .addToBackStack("Details")
            .commit()
    }
}