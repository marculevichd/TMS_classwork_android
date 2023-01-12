package com.example.tms_classwork_android.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.tms_classwork_android.databinding.FragmentHomeBinding
import com.example.tms_classwork_android.domain.model.UserModel
import com.example.tms_classwork_android.presentation.MainPresenter
import com.example.tms_classwork_android.utils.Navigation.fmReplace
import com.example.tms_classwork_android.presentation.auth.OnBoardingFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeView {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var homePresenter: HomePresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.setView(this)

        homePresenter.showUserData()

        binding.btnGoToOnBoarding.setOnClickListener {
            fmReplace(parentFragmentManager, OnBoardingFragment(), false)
        }
    }

    override fun showUserData(userModel: UserModel) {
        binding.textViewUserCreds.text = "${userModel.userName} \n ${userModel.userPassword}"
    }

}