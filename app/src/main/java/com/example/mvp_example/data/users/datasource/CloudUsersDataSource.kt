package com.example.mvp_example.data.users.datasource

import com.example.mvp_example.data.api.GitHubApi
import com.example.mvp_example.data.model.GitHubUser
import io.reactivex.Observable
import javax.inject.Inject

class CloudUsersDataSource @Inject constructor(
    private val gitHubApi: GitHubApi,
) : UsersDataSource {

    override fun getUsers(): Observable<List<GitHubUser>> =
        gitHubApi
            .getUsers()
            .toObservable()

}