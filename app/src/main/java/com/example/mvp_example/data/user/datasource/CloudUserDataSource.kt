package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.data.api.GitHubApi
import com.example.mvp_example.data.user.GitHubUser
import io.reactivex.Maybe
import io.reactivex.Single

class CloudUserDataSource(private val gitHubApi: GitHubApi) : UserDataSource {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubApi.getUsers()

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubApi.getUserByLogin(userId)
            .toMaybe()

}