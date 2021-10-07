package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.data.storage.GitHubStorage
import com.example.mvp_example.data.user.GitHubUser
import io.reactivex.Maybe
import io.reactivex.Single

class CacheUserDataSourceImpl(private val gitHubStorage: GitHubStorage) : CacheUserDataSource {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubStorage
            .gitHubUserDao()
            .fetchUsers()

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubStorage
            .gitHubUserDao()
            .fetchUserByLogin(userId)
            .toMaybe()

    override fun retain(users: List<GitHubUser>): Single<List<GitHubUser>> =
        gitHubStorage
            .gitHubUserDao()
            .retain(users)
            .andThen(getUsers())

    override fun retain(user: GitHubUser): Single<GitHubUser> =
        gitHubStorage
            .gitHubUserDao()
            .retain(user)
            .andThen(getUserByLogin(user.id))
            .toSingle()

}