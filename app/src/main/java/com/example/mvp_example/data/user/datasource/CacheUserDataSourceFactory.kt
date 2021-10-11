package com.example.mvp_example.data.user.datasource

object CacheUserDataSourceFactory {

    fun create(): CacheUserDataSource =
        CacheUserDataSourceImpl(GitHubStorageFactory.create())

}