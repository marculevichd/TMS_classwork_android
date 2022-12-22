package com.example.tms_classwork_android.presentation

import com.example.tms_classwork_android.domain.auth.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity){
        mainView = mainActivity
    }

    fun checkUserExists(){
        val doesUserExists = authInteractor.checkUserExist()
        mainView.userExistsResult(doesUserExists)
    }
}