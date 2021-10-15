package com.example.mvp_example.presentation.repos

import com.example.mvp_example.presentation.GitHubUserReposViewModel
import com.example.mvp_example.presentation.GitHubUserViewModel
import com.example.mvp_example.presentation.ScreenView
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface ReposView : ScreenView {

    @SingleState
    fun showRepos(users: List<GitHubUserReposViewModel>)
}