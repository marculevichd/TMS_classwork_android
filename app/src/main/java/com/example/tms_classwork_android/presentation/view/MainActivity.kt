package com.example.tms_classwork_android.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tms_classwork_android.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()//полезно для дз(вложенность)
        fragmentTransaction.add(R.id.activity_container, OnBoardingFragment())
        fragmentTransaction.commit()
    }
}