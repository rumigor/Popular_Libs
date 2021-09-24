package com.example.mvp_example.presentation.users


import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.mvp_example.repo.GitHubUser
import com.example.mvp_example.repo.GitHubUserRepository
import com.example.mvp_example.presentation.user.UserScreen
import io.reactivex.rxjava3.disposables.CompositeDisposable

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router
) : MvpPresenter<UsersView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposable.add(
            userRepository
                .getUsers()
                .subscribe(
                    viewState::showUsers,
                    viewState::showError
                )
        )
    }

    fun displayUser(user: GitHubUser) =
        router.navigateTo(UserScreen(user.login))

    override fun onDestroy() {
        disposable.clear()
    }
}