package com.example.tms_classwork_android.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.databinding.FragmentLoginBinding
import com.example.tms_classwork_android.presentation.home.HomeFragment
import com.example.tms_classwork_android.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonShowCreds.setOnClickListener {
            viewModel.loginUser(
                binding.etLogin.text.toString(),
                binding.etPassword.text.toString()
            )
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if(it!=null){
                navigate(it)
                viewModel.userNavigated()
            }

        }

    }


}



