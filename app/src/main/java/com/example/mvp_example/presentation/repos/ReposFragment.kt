package com.example.mvp_example.presentation.repos

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvp_example.App
import com.example.mvp_example.R
import com.example.mvp_example.arguments
import com.example.mvp_example.data.di.ReposComponent
import com.example.mvp_example.data.userRepositories.UserRepositories
import com.example.mvp_example.data.users.GitHubUsersRepository
import com.example.mvp_example.databinding.ViewReposBinding
import com.example.mvp_example.presentation.GitHubUserReposViewModel
import com.example.mvp_example.presentation.repos.adapter.RepoAdapter
import com.example.mvp_example.scheduler.Schedulers
import com.example.mvp_example.scheduler.SchedulersFactory
import com.github.terrakok.cicerone.Router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class ReposFragment : MvpAppCompatFragment(R.layout.view_repos), ReposView, RepoAdapter.Delegate {

    companion object Factory {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            ReposFragment()
                .arguments(ARG_USER_LOGIN to userId)

    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var repositories: UserRepositories

    private val presenter: ReposPresenter by moxyPresenter {
        ReposPresenter(
            repositories = repositories,
            userName = userLogin,
            schedulers = SchedulersFactory.create()
        )
    }

    private val viewBinding: ViewReposBinding by viewBinding()
    private val repoAdapter = RepoAdapter(delegate = this)

    private var reposComponent: ReposComponent? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        reposComponent =
            (requireActivity().application as? App)
                ?.gitHubApplicationComponent
                ?.gitReposComponent()
                ?.build()
                ?.also { it.inject(this) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.repos.adapter = repoAdapter
    }

    override fun showRepos(repos: List<GitHubUserReposViewModel>) {
        repoAdapter.submitList(repos)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        reposComponent = null
    }

    override fun onRepositoryPicked(repository: GitHubUserReposViewModel) {
        Toast.makeText(
            context,
            "forks - ${repository.forks}, watchers - ${repository.watchers}",
            Toast.LENGTH_LONG
        ).show()
    }
}

