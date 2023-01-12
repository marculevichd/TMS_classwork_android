package com.example.tms_classwork_android.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.utils.BundleConstants.IMAGE_VIEW
import com.example.tms_classwork_android.utils.BundleConstants.DATE
import com.example.tms_classwork_android.utils.BundleConstants.NAME
import com.example.tms_classwork_android.utils.NavHelper.navigate
import com.example.tms_classwork_android.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.dtName)
        val detailsDate = view.findViewById<TextView>(R.id.dtDate)
        val detailsImage = view.findViewById<ImageView>(R.id.dtImg)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)


        val bundle = arguments
        bundle?.let { safeBundle ->

            val name = safeBundle.getString(NAME)
            val date = safeBundle.getString(DATE)
            val image = safeBundle.getInt(IMAGE_VIEW)

            detailsName.text = name
            detailsDate.text = date
            detailsImage.setBackgroundResource(image)
        }
        btnLogout.setOnClickListener {
            viewModel.logoutUser()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                replaceGraph(it)
            }
        }

    }
}