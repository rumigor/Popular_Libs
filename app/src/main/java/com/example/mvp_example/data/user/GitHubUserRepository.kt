package com.example.mvp_example.data.user


import com.example.mvp_example.data.model.GitHubUser
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.rxjava3.core.Single


interface GitHubUserRepository {

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}

