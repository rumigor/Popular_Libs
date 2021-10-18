package com.example.mvp_example.data.users.datasource

import com.example.mvp_example.data.model.GitHubUser
import io.reactivex.Observable

interface UsersDataSource {

    fun getUsers(): Observable<List<GitHubUser>>

}