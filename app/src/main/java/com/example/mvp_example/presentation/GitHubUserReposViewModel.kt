package com.example.mvp_example.presentation

import com.example.mvp_example.data.user.GitHubUserRepo

data class GitHubUserReposViewModel(
    val name: String
) {

    object Mapper {

        fun map(repos: GitHubUserRepo) =
            GitHubUserReposViewModel(
                repos.name
            )

    }
}