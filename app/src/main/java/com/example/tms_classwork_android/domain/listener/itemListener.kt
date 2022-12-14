package com.example.tms_classwork_android.domain.listener

interface itemListener {

    fun onClick()

    fun onElementSelected(name: String, date: String, imageView: Int)
}