package com.example.tms_classwork_android.presentation.auth

import com.example.tms_classwork_android.domain.auth.AuthInteractor
import javax.inject.Inject

class OnBoardingPresenter @Inject constructor() {

    private lateinit var onBoardingView: OnBoardingView

    fun setView(onBoardingFragment: OnBoardingFragment){
        onBoardingView=onBoardingFragment
    }

    fun goToItemsFragment() {
        onBoardingView.goToItemsFragment()
    }



}