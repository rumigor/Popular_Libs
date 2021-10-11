package com.example.mvp_example.presentation.users


import com.example.mvp_example.presentation.GitHubUserViewModel
import com.example.mvp_example.presentation.ScreenView
import moxy.viewstate.strategy.alias.SingleState

interface UsersView : ScreenView {

    /**
     * Показывает список пользователей.
     * @param users список пользователей
     */
    @SingleState
    fun showUsers(users: List<GitHubUserViewModel>)

}