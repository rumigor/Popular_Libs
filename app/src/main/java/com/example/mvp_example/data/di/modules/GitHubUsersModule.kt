package com.example.mvp_example.data.di.modules

import dagger.Module

@Module(includes = [GitHubUsersRepositoryModule::class])
interface GitHubUsersModule