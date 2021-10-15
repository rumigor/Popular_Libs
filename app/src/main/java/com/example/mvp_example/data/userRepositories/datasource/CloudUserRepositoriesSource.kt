package com.example.mvp_example.data.userRepositories.datasource

import com.example.mvp_example.data.api.GitHubApi
import com.example.mvp_example.data.model.Repository
import io.reactivex.Observable
import javax.inject.Inject

class CloudUserRepositoriesSource @Inject constructor(
    private val gitHubApi: GitHubApi
) : UserRepositoriesDataSource{
    override fun getReposbyUserLogin(userId: String): Observable<List<Repository>> =
        gitHubApi
            .getReposbyUserLogin(userId)
            .toObservable()
}