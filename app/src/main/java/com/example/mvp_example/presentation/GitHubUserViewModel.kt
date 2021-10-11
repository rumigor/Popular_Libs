package com.example.mvp_example.presentation

import com.example.mvp_example.data.user.GitHubUser

data class GitHubUserViewModel(
    val login: String,
    val avatar: String
) {

    object Mapper {

        fun map(user: GitHubUser) =
            GitHubUserViewModel(
                user.login.toUpperCase(),
                user.avatar
            )

    }

}