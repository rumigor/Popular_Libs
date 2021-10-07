package com.example.mvp_example.data.user.datasource

import com.example.mvp_example.App
import com.example.mvp_example.data.storage.GitHubStorageFactory

object CacheUserDataSourceFactory {

    fun create(): CacheUserDataSource =
        CacheUserDataSourceImpl(
            GitHubStorageFactory.createInMemory(App.ContextHolder.context)
        )

}