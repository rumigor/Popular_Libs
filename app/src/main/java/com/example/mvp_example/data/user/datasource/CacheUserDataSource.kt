package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.data.model.GitHubUser
import io.reactivex.Single

interface CacheUserDataSource : UserDataSource {

    fun retain(user: GitHubUser): Single<GitHubUser>

}