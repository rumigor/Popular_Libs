package com.example.mvp_example.data.user

import com.example.mvp_example.data.user.datasource.CacheUserDataSourceFactory
import com.example.mvp_example.data.user.datasource.UserDataSourceFactory

object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository =
        GitHubUserRepositoryImpl(
            UserDataSourceFactory.create(),
            CacheUserDataSourceFactory.create()
        )

}