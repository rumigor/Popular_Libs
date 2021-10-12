package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.data.api.GitHubApi
import com.example.mvp_example.data.model.GitHubUser
import io.reactivex.Maybe
import javax.inject.Inject

class CloudUserDataSource @Inject constructor(
    private val gitHubApi: GitHubApi,
) : UserDataSource {

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubApi.getUserByLogin(userId)
            .toMaybe()

}