package com.example.mvp_example.data.di

import android.content.Context
import com.example.mvp_example.App
import com.example.mvp_example.data.di.modules.GitHubApiModule
import com.example.mvp_example.data.di.modules.GitHubStorageModule
import com.example.mvp_example.data.di.modules.GitHubUsersModule
import com.example.mvp_example.scheduler.Schedulers
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, GitHubUsersModule::class, GitHubApiModule::class, GitHubStorageModule::class])
interface ApplicationComponent : AndroidInjector<App> {

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

        fun build(): ApplicationComponent

    }

}
