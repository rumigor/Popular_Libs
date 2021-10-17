package com.example.mvp_example.data.di.modules

import com.example.mvp_example.data.di.GitHubUsersComponent
import com.example.mvp_example.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [GitHubUsersComponent::class])
interface GitHubApplicationModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}