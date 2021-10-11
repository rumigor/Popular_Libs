package com.example.mvp_example.data.di.modules

import com.example.mvp_example.data.api.GitHubApi
import com.example.mvp_example.data.api.GitHubApiInterceptor
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class GitHubApiModule {

    @Named("github_api")
    @Provides
    fun provideBaseUrlProd(): String = "https://api.github.com"

    @Named("github_api_test")
    @Provides
    fun provideBaseUrlTest(): String = "https://api-test.github.com"

    @Reusable
    @Provides
    fun provideGitHubApi(@Named("github_api") baseUrl: String): GitHubApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(GitHubApiInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GitHubApi::class.java)

}