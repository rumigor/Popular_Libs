package com.example.mvp_example.presentation.repos

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ReposScreen(private val userName: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        ReposFragment.newInstance(userName)

}