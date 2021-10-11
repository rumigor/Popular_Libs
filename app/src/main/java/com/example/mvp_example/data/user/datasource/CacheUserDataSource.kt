package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.data.user.GitHubUser
import io.reactivex.Single

interface CacheUserDataSource : UserDataSource {

    fun retain(users: List<GitHubUser>): Single<List<GitHubUser>>
    fun retain(user: GitHubUser): Single<GitHubUser>

}