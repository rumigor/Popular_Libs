package com.example.mvp_example.presentation.repos

import com.example.mvp_example.data.user.GitHubUserRepository
import com.example.mvp_example.presentation.GitHubUserReposViewModel
import com.example.mvp_example.presentation.GitHubUserViewModel
import com.example.mvp_example.presentation.user.UserScreen
import com.example.mvp_example.scheduler.Schedulers
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import moxy.MvpPresenter

class ReposPresenter (
    private val userRepository: GitHubUserRepository,
    private val userName: String,
    private val schedulers: Schedulers
        ) : MvpPresenter<ReposView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            userRepository
                .getUserRepos(userName)
                .map(GitHubUserViewModel.Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showRepos,
                    viewState::showError
                )
    }

    fun displayUser(user: GitHubUserViewModel) {
        router.navigateTo(UserScreen(user.login))
    }

    override fun onDestroy() {
        disposables.dispose()
    }

}