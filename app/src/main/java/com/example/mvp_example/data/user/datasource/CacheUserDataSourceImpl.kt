package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.data.storage.GitHubStorage
import com.example.mvp_example.data.user.GitHubUser
import io.reactivex.Maybe
import io.reactivex.Single

class CacheUserDataSourceImpl(private val gitHubStorage: GitHubStorage) : CacheUserDataSource {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubStorage
            .getGitHubUserDao()
            .fetchUsers()

    override fun getUserRepos(userId: String): Maybe<GitHubUser> =
        gitHubStorage
            .getGitHubUserDao()
            .fetchUserByLogin(userId)
            .toMaybe()

    override fun retain(users: List<GitHubUser>): Single<List<GitHubUser>> =
        gitHubStorage
            .getGitHubUserDao()
            .retain(users)
            .andThen(getUsers())

    override fun retain(user: GitHubUser): Single<GitHubUser> =
        gitHubStorage
            .getGitHubUserDao()
            .retain(user)
            .andThen(getUserRepos(user.id))
            .toSingle()
}