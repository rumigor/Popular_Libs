package com.example.mvp_example.data.di

import com.example.mvp_example.data.di.modules.GitHubUserModule
import com.example.mvp_example.presentation.user.UserFragment
import dagger.Subcomponent

@GitHubUser
@Subcomponent(modules = [GitHubUserModule::class])
interface GitHubUserComponent {

    fun inject(userFragment: UserFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): GitHubUserComponent

    }
}