package com.example.mvp_example.data.user


import com.example.mvp_example.data.model.GitHubUser
import io.reactivex.Observable


interface GitHubUserRepository {

    fun getUsers(): Observable<List<GitHubUser>>

}
