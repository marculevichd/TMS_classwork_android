package com.example.tms_classwork_android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.tms_classwork_android.R
import com.example.tms_classwork_android.databinding.ActivityMainBinding
import com.example.tms_classwork_android.presentation.auth.LoginFragment
import com.example.tms_classwork_android.presentation.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.zip.Inflater
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {


    private var _binding: ActivityMainBinding? = null

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)
        setContentView(R.layout.activity_main)

        mainPresenter.setView(this)

        mainPresenter.checkUserExists()


    }

    override fun userExistsResult(userExist: Boolean) {

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(
            R.id.activity_container,
            when (userExist) {
                true -> HomeFragment()
                false -> LoginFragment()
            }
        )
        fragmentTransaction.commit()

    }
}