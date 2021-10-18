package com.example.mvp_example.data.api

import com.example.mvp_example.data.model.GitHubUser
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GitHubApi {

    @GET("/users")
    fun getUsers(@Query("since") since: Int? = null): Single<List<GitHubUser>>

    @GET("/users/{username}")
    fun getUserByLogin(@Path("username") login: String): Single<GitHubUser>

}