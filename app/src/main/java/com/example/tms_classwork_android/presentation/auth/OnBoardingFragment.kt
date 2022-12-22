package com.example.tms_classwork_android.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tms_classwork_android.databinding.FragmentOnBoardingBinding
import com.example.tms_classwork_android.utils.Navigation
import com.example.tms_classwork_android.presentation.home.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment(), OnBoardingView {

    @Inject
    lateinit var onBoardingPresenter: OnBoardingPresenter

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding: FragmentOnBoardingBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBoardingPresenter.setView(this)

        binding.btnFinish2.setOnClickListener {
            onBoardingPresenter.goToItemsFragment()
        }
    }

    override fun goToItemsFragment() {
        Navigation.fmReplace(parentFragmentManager, ItemsFragment(), false)
    }
}