package com.example.mvp_example.data.user


import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.rxjava3.core.Single


interface GitHubUserRepository {

    fun getUsers(): Observable<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}

