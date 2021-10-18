package com.example.mvp_example.data.di.modules

import com.example.mvp_example.data.users.GitHubUsersRepository
import com.example.mvp_example.data.users.GitHubUsersRepositoryImpl
import com.example.mvp_example.data.users.datasource.CacheUsersDataSource
import com.example.mvp_example.data.users.datasource.CacheUsersDataSourceImpl
import com.example.mvp_example.data.users.datasource.CloudUsersDataSource
import com.example.mvp_example.data.users.datasource.UsersDataSource
import dagger.Binds
import dagger.Module

@Module(includes = [GitHubStorageModule::class, GitHubApiModule::class])
interface GitHubUsersRepositoryModule {

    @Binds
    fun bindGitHubUsersRepository(repository: GitHubUsersRepositoryImpl): GitHubUsersRepository

    @Binds
    fun bindUsersDataSource(dataSource: CloudUsersDataSource): UsersDataSource

    @Binds
    fun bindCacheUsersDataSource(dataSource: CacheUsersDataSourceImpl): CacheUsersDataSource

}