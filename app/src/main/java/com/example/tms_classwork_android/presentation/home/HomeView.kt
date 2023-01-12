package com.example.tms_classwork_android.presentation.home

import com.example.tms_classwork_android.domain.model.UserModel

interface HomeView {

    fun showUserData(userModel: UserModel)
}