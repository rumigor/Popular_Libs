package com.example.mvp_example


import com.example.mvp_example.data.di.GitHubApplicationComponent
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.internal.MapFactory.builder
import io.reactivex.plugins.RxJavaPlugins

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App> =
        gitHubApplicationComponent

    val gitHubApplicationComponent: GitHubApplicationComponent by lazy {
        DaggerAppl
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

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {  }
    }

}