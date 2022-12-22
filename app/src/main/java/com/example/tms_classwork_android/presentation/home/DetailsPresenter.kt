package com.example.tms_classwork_android.presentation.home

import com.example.tms_classwork_android.domain.auth.AuthInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var detailsView: DetailsView

    fun setView(detailsFragment: DetailsFragment) {
        detailsView = detailsFragment
    }


    fun getArguments(name: String?, date: String?, imageView: Int) {
        detailsView.displayItemData(
            when (name.isNullOrEmpty()) {
                true -> "NO DATA"
                false -> name
            },
            when (date.isNullOrEmpty()) {
                true -> "NO DATA"
                false -> date
            },
            imageView
        )
    }

    fun logoutUser() {
        authInteractor.logoutUser()
        detailsView.userLogedOut()
    }

}