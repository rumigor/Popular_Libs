package com.example.mvp_example.data.di

import android.content.Context
import com.example.mvp_example.App
import com.example.mvp_example.data.di.GitHubUsersComponent.Builder
import com.example.mvp_example.data.di.modules.GitHubApplicationModule
import com.example.mvp_example.scheduler.Schedulers
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [AndroidInjectionModule::class, GitHubApplicationModule::class])
interface GitHubApplicationComponent : AndroidInjector<App> {

    fun gitHubUsersComponent(): GitHubUsersComponent.Builder
    fun gitHubUserComponent(): GitHubUserComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): GitHubApplicationComponent

    }
}