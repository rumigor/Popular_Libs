package com.example.mvp_example.data.di.modules

import com.example.mvp_example.data.userRepositories.UserRepositories
import com.example.mvp_example.data.userRepositories.UserRepositoriesImpl
import com.example.mvp_example.data.userRepositories.datasource.CacheUserRepositoriesSource
import com.example.mvp_example.data.userRepositories.datasource.CacheUserRepositoriesSourceImpl
import com.example.mvp_example.data.userRepositories.datasource.CloudUserRepositoriesSource
import com.example.mvp_example.data.userRepositories.datasource.UserRepositoriesDataSource
import dagger.Binds
import dagger.Module

@Module(includes = [GitHubStorageModule::class, GitHubApiModule::class])
interface ReposRepositoryModule {

    @Binds
    fun bindUserRepositories(repository: UserRepositoriesImpl): UserRepositories

    @Binds
    fun bindUserRepositoriesDataSource(dataSource: CloudUserRepositoriesSource): UserRepositoriesDataSource

    @Binds
    fun bindCacheUserRepositoriesSource(dataSource: CacheUserRepositoriesSourceImpl): CacheUserRepositoriesSource
}