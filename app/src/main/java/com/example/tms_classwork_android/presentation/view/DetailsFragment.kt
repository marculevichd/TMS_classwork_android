package com.example.tms_classwork_android.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.databinding.FragmentDetailsBinding
import com.example.tms_classwork_android.databinding.FragmentItemsBinding

class DetailsFragment : Fragment() {


    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        bundle?.let { safeBundle ->

            val name = safeBundle.getString("name")
            val date = safeBundle.getString("date")
            val image = safeBundle.getInt("imageView")

            viewBinding.dtName.text = name
            viewBinding.dtDate.text = date
            viewBinding.dtImg.setBackgroundResource(image)
        }
    }
}