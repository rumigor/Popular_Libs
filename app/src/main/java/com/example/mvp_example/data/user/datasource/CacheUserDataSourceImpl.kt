package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.data.di.InMemory
import com.example.mvp_example.data.model.GitHubUser
import com.example.mvp_example.data.storage.GitHubStorage
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class CacheUserDataSourceImpl @Inject constructor(
    @InMemory private val gitHubStorage: GitHubStorage
) : CacheUserDataSource {

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubStorage
            .gitHubUserDao()
            .fetchUserByLogin(userId)
            .toMaybe()

    override fun retain(user: GitHubUser): Single<GitHubUser> =
        gitHubStorage
            .gitHubUserDao()
            .retain(user)
            .andThen(Single.just(user))

}