package com.example.mvp_example.presentation.users

import com.example.mvp_example.repo.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : MvpView {


    @SingleState
    fun showUsers(users: List<GitHubUser>)
    @SingleState
    fun showError(error: Throwable)

}