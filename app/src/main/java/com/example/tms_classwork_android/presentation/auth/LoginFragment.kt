package com.example.tms_classwork_android.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tms_classwork_android.databinding.FragmentLoginBinding
import com.example.tms_classwork_android.utils.Navigation.fmReplace
import com.example.tms_classwork_android.presentation.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginView {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginPresenter.setView(this)

        binding.buttonShowCreds.setOnClickListener {
            loginPresenter.loginUser(
                binding.etLogin.text.toString(),
                binding.etPassword.text.toString()
            )
        }
    }

    override fun userLoggedIn() {
        fmReplace(parentFragmentManager, HomeFragment(), false)

    }
}



