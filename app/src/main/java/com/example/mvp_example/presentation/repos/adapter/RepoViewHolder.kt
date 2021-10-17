package com.example.mvp_example.presentation.repos.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvp_example.click
import com.example.mvp_example.databinding.ViewRepositoryBinding
import com.example.mvp_example.presentation.GitHubUserReposViewModel


class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val viewBinding: ViewRepositoryBinding by viewBinding()

    fun bind(repository: GitHubUserReposViewModel, delegate: RepoAdapter.Delegate?) {
        with(viewBinding) {
            repoName.text = repository.name

            root.click { delegate?.onRepositoryPicked(repository) }
        }
    }
}