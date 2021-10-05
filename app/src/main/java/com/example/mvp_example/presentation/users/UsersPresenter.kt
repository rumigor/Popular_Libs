package com.example.mvp_example.presentation.users


import com.example.mvp_example.presentation.GitHubUserViewModel
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.example.mvp_example.data.user.GitHubUserRepository
import com.example.mvp_example.presentation.user.UserScreen
import com.example.mvp_example.scheduler.Schedulers
import io.reactivex.disposables.CompositeDisposable

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
    private val schedulers: Schedulers
): MvpPresenter<UsersView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables.add(
            userRepository
                .getUsers()
                .observeOn(schedulers.background())
                .map { users -> users.map(GitHubUserViewModel.Mapper::map) }
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showUsers,
                    viewState::showError
                )
        )
    }

    fun displayUser(user: GitHubUserViewModel) {
        router.navigateTo(UserScreen(user.login))
    }

    override fun onDestroy() {
        disposables.dispose()
    }

}