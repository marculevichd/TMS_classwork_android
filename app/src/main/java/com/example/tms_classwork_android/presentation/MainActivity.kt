package com.example.tms_classwork_android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.databinding.ActivityMainBinding
import com.example.tms_classwork_android.presentation.auth.LoginFragment
import com.example.tms_classwork_android.presentation.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.zip.Inflater


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private var _binding: ActivityMainBinding? = null
    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)
        setContentView(R.layout.activity_main)

        viewModel.checkUserExists()


        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment

        navController = navHostFragment.navController

        viewModel.nav.observe(this) {
            navController.setGraph(it)
        }
    }
}