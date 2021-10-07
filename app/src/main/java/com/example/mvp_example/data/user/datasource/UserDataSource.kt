package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.data.user.GitHubUser
import io.reactivex.Maybe
import io.reactivex.Single

interface UserDataSource {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}