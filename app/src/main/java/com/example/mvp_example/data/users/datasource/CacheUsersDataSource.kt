package com.example.mvp_example.data.users.datasource

import com.example.mvp_example.data.model.GitHubUser
import io.reactivex.Single

interface CacheUsersDataSource : UsersDataSource {

    fun retain(users: List<GitHubUser>): Single<List<GitHubUser>>

}