package com.example.mvp_example.data.users

import com.example.mvp_example.data.model.GitHubUser
import io.reactivex.Observable

interface GitHubUsersRepository {

    fun getUsers(): Observable<List<GitHubUser>>

}