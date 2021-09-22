package com.example.mvp_example

import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun userInfo(userName: String) = FragmentScreen {UserInfoFragment.newInstance(userName)}
}

