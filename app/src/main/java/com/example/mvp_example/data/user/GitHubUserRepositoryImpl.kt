package com.example.mvp_example.data.user

import com.example.mvp_example.data.user.datasource.CacheUserDataSource
import com.example.mvp_example.data.user.datasource.UserDataSource
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.rxjava3.core.Single
import java.lang.RuntimeException

class GitHubUserRepositoryImpl(
    private val cloud: UserDataSource,
    private val cache: CacheUserDataSource
) : GitHubUserRepository {

    override fun getUsers(): Observable<List<GitHubUser>> =
        Observable.merge(
            cache.getUsers().toObservable(),
            cloud.getUsers().flatMap(cache::retain).toObservable()
        )


    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        cache.getUserByLogin(userId)
            .switchIfEmpty(cloud.getUserByLogin(userId))

}