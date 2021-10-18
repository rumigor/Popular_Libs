package com.example.mvp_example.data.di.modules

import com.example.mvp_example.data.user.GitHubUserRepository
import com.example.mvp_example.data.user.GitHubUserRepositoryImpl
import com.example.mvp_example.data.user.datasource.CacheUserDataSource
import com.example.mvp_example.data.user.datasource.CacheUserDataSourceImpl
import com.example.mvp_example.data.user.datasource.CloudUserDataSource
import com.example.mvp_example.data.user.datasource.UserDataSource
import dagger.Binds
import dagger.Module

@Module(includes = [GitHubStorageModule::class, GitHubApiModule::class])
interface GitHubUserRepositoryModule {

    @Binds
    fun bindGitHubUserRepository(repository: GitHubUserRepositoryImpl): GitHubUserRepository

    @Binds
    fun bindUserDataSource(dataSource: CloudUserDataSource): UserDataSource

    @Binds
    fun bindCacheUserDataSource(dataSource: CacheUserDataSourceImpl): CacheUserDataSource

}