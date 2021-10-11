package com.example.mvp_example.data.user.datasource

object UserDataSourceFactory {

    fun create(): UserDataSource = CloudUserDataSource(GitHubApiFactory.create())

}