package com.example.mvp_example.presentation.user

import com.example.mvp_example.repo.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {


    @SingleState
    fun showUser(user: GitHubUser)
    @SingleState
    fun showError(e: Throwable)


}