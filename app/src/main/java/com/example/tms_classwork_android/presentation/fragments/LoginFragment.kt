package com.example.tms_classwork_android.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.databinding.FragmentLoginBinding
import com.example.tms_classwork_android.presentation.Navigation.fmReplace
import com.example.tms_classwork_android.presentation.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.viewHandler = ViewHandler()
        binding.lifecycleOwner = viewLifecycleOwner
    }

    inner class ViewHandler{
        fun goToTheOnBoarding(){
            fmReplace(parentFragmentManager, OnBoardingFragment(), false)
        }
    }


}