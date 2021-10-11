package com.example.mvp_example.presentation.repos

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvp_example.App
import com.example.mvp_example.R
import com.example.mvp_example.arguments
import com.example.mvp_example.data.user.GitHubUserRepositoryFactory
import com.example.mvp_example.databinding.ViewReposBinding
import com.example.mvp_example.databinding.ViewUsersBinding
import com.example.mvp_example.presentation.GitHubUserReposViewModel
import com.example.mvp_example.presentation.GitHubUserViewModel
import com.example.mvp_example.presentation.repos.adapter.RepoAdapter
import com.example.mvp_example.presentation.user.UserFragment
import com.example.mvp_example.presentation.users.UsersFragment
import com.example.mvp_example.presentation.users.UsersPresenter
import com.example.mvp_example.presentation.users.UsersView
import com.example.mvp_example.presentation.users.adapter.UsersAdapter
import com.example.mvp_example.scheduler.SchedulersFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ReposFragment : MvpAppCompatFragment(R.layout.view_repos), ReposView {

    companion object Factory {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            ReposFragment()
                .arguments(ARG_USER_LOGIN to userId)

    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private val presenter: ReposPresenter by moxyPresenter {
        ReposPresenter(
            userRepository = GitHubUserRepositoryFactory.create(),
            userName = userLogin,
            schedulers = SchedulersFactory.create()
        )
    }

    private val viewBinding: ViewReposBinding by viewBinding()
    private val repoAdapter = RepoAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.repos.adapter = repoAdapter
    }

    override fun showRepos(repos: List<GitHubUserReposViewModel>){
        repoAdapter.submitList(repos)
    }
    override fun showError(error: Throwable) {

    }
}

