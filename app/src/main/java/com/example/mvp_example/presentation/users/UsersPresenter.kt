package com.example.mvp_example.presentation.users


import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.mvp_example.repo.GitHubUser
import com.example.mvp_example.repo.GitHubUserRepository
import com.example.mvp_example.presentation.user.UserScreen

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router
): MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUsers()
            .let(viewState::showUsers)
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))

}