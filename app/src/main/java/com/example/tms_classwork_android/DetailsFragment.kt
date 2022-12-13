package com.example.tms_classwork_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.dtName)
        val detailsDate = view.findViewById<TextView>(R.id.dtDate)
        val detailsImage = view.findViewById<ImageView>(R.id.dtImg)

        val bundle = arguments
        bundle?.let { safeBundle ->

            val name = safeBundle.getString("name")
            val date = safeBundle.getString("date")
            val image = safeBundle.getInt("imageView")

            detailsName.text = name
            detailsDate.text = date
            detailsImage.setBackgroundResource(image)
        }
    }
}