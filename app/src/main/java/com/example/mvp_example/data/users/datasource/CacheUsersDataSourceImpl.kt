package com.example.mvp_example.data.users.datasource

import com.example.mvp_example.data.di.InMemory
import com.example.mvp_example.data.model.GitHubUser
import com.example.mvp_example.data.storage.GitHubStorage
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class CacheUsersDataSourceImpl @Inject constructor(
    @InMemory private val gitHubStorage: GitHubStorage
) : CacheUsersDataSource {

    override fun getUsers(): Observable<List<GitHubUser>> =
        gitHubStorage
            .gitHubUserDao()
            .fetchUsers()

    override fun retain(users: List<GitHubUser>): Single<List<GitHubUser>> =
        gitHubStorage
            .gitHubUserDao()
            .retain(users)
            .andThen(getUsers().firstOrError())

}