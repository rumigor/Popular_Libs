package com.example.mvp_example

import com.example.mvp_example.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserInfoPresenter (val router: Router) : MvpPresenter<UsersView>() {

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}