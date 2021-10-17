package com.example.mvp_example.presentation.user

import com.example.mvp_example.presentation.GitHubUserReposViewModel
import com.example.mvp_example.presentation.GitHubUserViewModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {


    @SingleState
    fun showUser(user: GitHubUserViewModel)
    @SingleState
    fun showError(e: Throwable)



}