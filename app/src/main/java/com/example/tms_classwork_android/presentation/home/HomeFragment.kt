package com.example.tms_classwork_android.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.databinding.FragmentHomeBinding
import com.example.tms_classwork_android.databinding.FragmentLoginBinding
import com.example.tms_classwork_android.presentation.Navigation
import com.example.tms_classwork_android.presentation.Navigation.fmReplace
import com.example.tms_classwork_android.presentation.auth.LoginViewModel
import com.example.tms_classwork_android.presentation.auth.OnBoardingFragment
import com.example.tms_classwork_android.utils.coroutinsExample.CorEx
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        CorEx().testCorExampleCansel()


        viewModel.showUserData()

        viewModel.userCreds.observe(viewLifecycleOwner) {
            binding.textViewUserCreds.text = "${it.userName} \n ${it.userPassword}"
        }
        binding.btnGoToOnBoarding.setOnClickListener {
            fmReplace(parentFragmentManager, OnBoardingFragment(), false)
        }

    }
}