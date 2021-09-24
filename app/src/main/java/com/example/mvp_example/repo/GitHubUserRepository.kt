package com.example.mvp_example.repo


import io.reactivex.rxjava3.core.Single


interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Single<GitHubUser>

}

