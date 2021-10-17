package com.example.mvp_example.presentation.user


import com.example.mvp_example.presentation.GitHubUserViewModel
import moxy.MvpPresenter
import com.example.mvp_example.data.user.GitHubUserRepository
import com.example.mvp_example.presentation.repos.ReposScreen
import com.example.mvp_example.scheduler.Schedulers
import com.github.terrakok.cicerone.Router
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val schedulers: Schedulers,
    private val router: Router
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables +=
            userRepository
                .getUserByLogin(userLogin)
                .map(GitHubUserViewModel.Mapper::map)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showUser,
                    viewState::showError
                )
    }

    override fun onDestroy() {
        disposables.clear()
    }

    fun displayRepositories(userLogin: String) {
        router.navigateTo(ReposScreen(userLogin))
    }

}


