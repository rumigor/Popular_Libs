package com.example.mvp_example.data.userRepositories.datasource

import com.example.mvp_example.data.di.InMemory
import com.example.mvp_example.data.model.Repository
import com.example.mvp_example.data.storage.GitHubStorage
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class CacheUserRepositoriesSourceImpl @Inject constructor(
    @InMemory private val gitHubStorage: GitHubStorage
) : CacheUserRepositoriesSource {
    override fun retainRepos(userId: String, repos: List<Repository>): Single<List<Repository>> =
        gitHubStorage
            .gitHubUserDao()
            .retainRepos(repos)
            .andThen(getReposbyUserLogin(userId).firstOrError())


    override fun getReposbyUserLogin(userId: String): Observable<List<Repository>> =
        gitHubStorage
            .gitHubUserDao()
            .fetchRepos()
            .toObservable()
}