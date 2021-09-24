package com.example.mvp_example.presentation.user


import moxy.MvpPresenter
import com.example.mvp_example.repo.GitHubUserRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
) : MvpPresenter<UserView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
       disposable.add(
        userRepository
           .getUserByLogin(userLogin)
           .subscribe(viewState::showUser,
           viewState::showError)
       )
    }

    override fun onDestroy() {
        disposable.clear()
    }

}


