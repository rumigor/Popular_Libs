package com.example.mvp_example.data.user

import com.example.mvp_example.data.model.GitHubUser
import com.example.mvp_example.data.user.datasource.CacheUserDataSource
import com.example.mvp_example.data.user.datasource.UserDataSource
import com.example.mvp_example.data.users.datasource.CacheUsersDataSource
import com.example.mvp_example.data.users.datasource.UsersDataSource
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject

class GitHubUserRepositoryImpl @Inject constructor(
    private val cloud: UserDataSource,
    private val cache: CacheUserDataSource
) : GitHubUserRepository {

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        cloud.getUserByLogin(userId)
            .flatMap { cache.retain(it).toMaybe() }

}