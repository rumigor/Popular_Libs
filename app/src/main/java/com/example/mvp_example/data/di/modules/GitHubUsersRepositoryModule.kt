package com.example.mvp_example.data.di.modules

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