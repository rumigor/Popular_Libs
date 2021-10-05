package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.data.api.GitHubApiFactory

object UserDataSourceFactory {

    fun create(): UserDataSource = CloudUserDataSource(GitHubApiFactory.create())

}