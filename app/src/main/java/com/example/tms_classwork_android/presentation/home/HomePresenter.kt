package com.example.tms_classwork_android.presentation.home

import com.example.tms_classwork_android.domain.auth.AuthInteractor
import com.example.tms_classwork_android.domain.items.ItemsInteractor
import javax.inject.Inject

class HomePresenter @Inject constructor(private val authInteractor: AuthInteractor){

    private lateinit var homeView: HomeView

    fun setView(homeFragment: HomeFragment) {
        homeView = homeFragment
    }



    fun showUserData(){
        homeView.showUserData(authInteractor.getUserCreds())
    }
}