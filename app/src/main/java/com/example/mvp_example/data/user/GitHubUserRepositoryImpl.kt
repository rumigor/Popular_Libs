package com.example.mvp_example.data.user

import com.example.mvp_example.data.model.GitHubUser
import com.example.mvp_example.data.users.datasource.CacheUsersDataSource
import com.example.mvp_example.data.users.datasource.UsersDataSource
import io.reactivex.Observable
import javax.inject.Inject

class GitHubUserRepositoryImpl @Inject constructor(
    private val cloud: UsersDataSource,
    private val cache: CacheUsersDataSource
) : GitHubUserRepository {

    override fun getUsers(): Observable<List<GitHubUser>> =
        Observable.merge(
            cache.getUsers(),
            cloud.getUsers().flatMapSingle(cache::retain)
        )

}