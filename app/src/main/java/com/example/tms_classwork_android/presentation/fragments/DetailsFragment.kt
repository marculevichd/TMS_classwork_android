package com.example.tms_classwork_android.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.utils.BundleConstants.IMAGE_VIEW
import com.example.tms_classwork_android.databinding.FragmentDetailsBinding
import com.example.tms_classwork_android.utils.BundleConstants.DATE
import com.example.tms_classwork_android.utils.BundleConstants.NAME


class DetailsFragment : Fragment() {

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


        val bundle = arguments
        bundle?.let { safeBundle ->

            val name = safeBundle.getString(NAME)
            val date = safeBundle.getString(DATE)
            val image = safeBundle.getInt(IMAGE_VIEW)

            detailsName.text = name
            detailsDate.text = date
            detailsImage.setBackgroundResource(image)
        }
    }
}