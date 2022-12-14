package com.example.tms_classwork_android.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tms_classwork_android.utils.BundleConstants.IMAGE_VIEW
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.databinding.FragmentDetailsBinding
import com.example.tms_classwork_android.databinding.FragmentOnBoardingBinding
import com.example.tms_classwork_android.presentation.factory.ItemsViewModelsFactory
import com.example.tms_classwork_android.presentation.fragments.ItemsFragment.Companion.DATE
import com.example.tms_classwork_android.presentation.fragments.ItemsFragment.Companion.NAME
import com.example.tms_classwork_android.presentation.viewmodel.DetailsViewModel
import com.example.tms_classwork_android.presentation.viewmodel.ItemsViewModel
import com.example.tms_classwork_android.presentation.viewmodel.MyParam


//1 способ создания констант


class DetailsFragment : Fragment() {

    private val vm: DetailsViewModel by viewModels()


    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        vm.bundleDetails.observe(viewLifecycleOwner){
            val bundle = arguments
            bundle?.let { safeBundle ->

                binding.dtName.text = safeBundle.getString(NAME)
                binding.dtDate.text = safeBundle.getString(DATE)
                binding.dtImg.setBackgroundResource(safeBundle.getInt(IMAGE_VIEW))
            }


        }




    }

}