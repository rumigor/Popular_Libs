package com.example.mvp_example.data.user

import com.example.mvp_example.data.user.datasource.CacheUserDataSource
import com.example.mvp_example.data.user.datasource.UserDataSource
import io.reactivex.Maybe
import io.reactivex.Observable

class GitHubUserRepositoryImpl(
    private val cloud: UserDataSource,
    private val cache: CacheUserDataSource
) : GitHubUserRepository {

    override fun getUsers(): Observable<List<GitHubUser>> =
        Observable.merge(
            cache.getUsers().toObservable(),
            cloud.getUsers().flatMap(cache::retain).toObservable()
        )

    override fun getUserRepos(userId: String): Observable<GitHubUser> =
        Observable.merge(
            cache.getUserRepos(userId).toObservable(),
            cloud.getUserRepos(userId).flatMap(cache::retain).toObservable()
        )
}