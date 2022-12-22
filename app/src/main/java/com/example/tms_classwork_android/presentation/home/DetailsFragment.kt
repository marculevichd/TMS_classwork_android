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
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.databinding.FragmentDetailsBinding
import com.example.tms_classwork_android.databinding.FragmentHomeBinding
import com.example.tms_classwork_android.presentation.auth.LoginFragment
import com.example.tms_classwork_android.utils.BundleConstants.IMAGE_VIEW
import com.example.tms_classwork_android.utils.BundleConstants.DATE
import com.example.tms_classwork_android.utils.BundleConstants.NAME
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsPresenter.setView(this)


        val bundle = arguments
        bundle?.let { safeBundle ->
            detailsPresenter.getArguments(
                safeBundle.getString(NAME),
                safeBundle.getString(DATE),
                safeBundle.getInt(IMAGE_VIEW)
            )
        }


        binding.btnLogout.setOnClickListener {
            detailsPresenter.logoutUser()
        }


    }

    override fun userLogedOut() {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, LoginFragment())
            .commit()
    }

    override fun displayItemData(name: String, date: String, imageView: Int) {
        binding.dtName.text = name
        binding.dtDate.text = date
        binding.dtImg.setBackgroundResource(imageView)
    }
}