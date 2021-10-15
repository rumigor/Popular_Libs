package com.example.mvp_example.presentation.repos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mvp_example.R
import com.example.mvp_example.presentation.GitHubUserReposViewModel
import com.example.mvp_example.presentation.users.adapter.UserDiff


class RepoAdapter(): ListAdapter<GitHubUserReposViewModel, RepoViewHolder>(RepoDiff) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder =
        RepoViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_repos, parent, false)
        )

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) =
        holder.bind(getItem(position))

}