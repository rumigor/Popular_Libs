package com.example.mvp_example.presentation

import android.os.Bundle
import com.example.mvp_example.*
import com.example.mvp_example.App.Navigation.navigatorHolder
import com.example.mvp_example.App.Navigation.router
import com.example.mvp_example.databinding.ActivityMainBinding
import com.example.mvp_example.presentation.users.UsersScreen
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(UsersScreen)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}

