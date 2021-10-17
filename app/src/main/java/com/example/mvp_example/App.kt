package com.example.mvp_example


import com.example.mvp_example.data.di.DaggerGitHubApplicationComponent
import com.example.mvp_example.data.di.GitHubApplicationComponent
import com.example.mvp_example.scheduler.DefaultSchedulers
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> = gitHubApplicationComponent

    val gitHubApplicationComponent: GitHubApplicationComponent by lazy {
        DaggerGitHubApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(DefaultSchedulers())
            }
            .build()
    }

}