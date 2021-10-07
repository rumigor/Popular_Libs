package com.example.mvp_example.data.user

import com.example.mvp_example.data.user.datasource.CacheUserDataSourceFactory
import com.example.mvp_example.data.user.datasource.UserDataSourceFactory

object GitHubUserRepositoryFactory {

    private val repository: GitHubUserRepository by lazy {
        GitHubUserRepositoryImpl(
            UserDataSourceFactory.create(),
            CacheUserDataSourceFactory.create()
        )
    }

    fun create(): GitHubUserRepository = repository

}