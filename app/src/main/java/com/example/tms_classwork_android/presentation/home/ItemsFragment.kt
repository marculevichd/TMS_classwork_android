package com.example.tms_classwork_android.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_classwork_android.utils.BundleConstants.IMAGE_VIEW
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.databinding.FragmentItemsBinding
import com.example.tms_classwork_android.presentation.adapter.ItemsAdapter
import com.example.tms_classwork_android.domain.listener.itemListener
import com.example.tms_classwork_android.domain.model.ItemsModel
import com.example.tms_classwork_android.utils.Navigation
import com.example.tms_classwork_android.utils.BundleConstants.DATE
import com.example.tms_classwork_android.utils.BundleConstants.NAME
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(), itemListener, ItemsView {

    private lateinit var itemsAdapter: ItemsAdapter

    private var _binding: FragmentItemsBinding? = null
    private val binding get() = _binding!!


    @Inject
    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        itemsPresenter.setView(this)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        itemsPresenter.getItems()

    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        itemsPresenter.itemClicked(name, date, imageView)
    }


    override fun itemsReceived(itemsList: List<ItemsModel>) {
        itemsAdapter.submitList(itemsList)
    }

    override fun imageViewClicked(msg: Int) {//////////////////// INT msg STRING msg
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun itemClicked(navigateWithBundle: NavigateWithBundle) {

        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString(NAME, navigateWithBundle.name)
        bundle.putString(DATE, navigateWithBundle.date)
        bundle.putInt(IMAGE_VIEW, navigateWithBundle.image)
        detailsFragment.arguments = bundle

        Navigation.fmReplace(parentFragmentManager, detailsFragment, true)
    }
}