package com.example.mvp_example.presentation.user

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.mvp_example.repo.GitHubUser
import com.example.mvp_example.repo.GitHubUserRepository
import com.example.mvp_example.presentation.user.UserScreen

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUserByLogin(userLogin)
            ?.let(viewState::showUser)
    }

}