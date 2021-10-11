package com.example.mvp_example.data.di

import com.example.mvp_example.data.di.modules.GitHubUsersModule
import com.example.mvp_example.presentation.users.UsersFragment
import dagger.Subcomponent


@GitHubUsers
@Subcomponent(modules = [GitHubUsersModule::class])
interface GitHubUsersComponent {

    fun inject(usersFragment: UsersFragment)

    @Subcomponent.Builder
    interface Builder {

        fun build(): GitHubUsersComponent

    }
}
