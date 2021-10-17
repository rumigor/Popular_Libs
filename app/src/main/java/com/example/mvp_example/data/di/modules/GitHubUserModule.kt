package com.example.mvp_example.data.di.modules

import dagger.Module

@Module(includes = [GitHubUserRepositoryModule::class])
interface GitHubUserModule