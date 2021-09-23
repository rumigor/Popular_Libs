package com.example.mvp_example.presentation.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvp_example.App.Navigation.router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.mvp_example.arguments
import com.example.mvp_example.repo.GitHubUser
import com.example.mvp_example.repo.GitHubUserRepositoryFactory
import com.example.mvp_example.databinding.ViewUsersBinding
import com.example.mvp_example.presentation.users.adapter.UsersAdapter
import com.example.mvp_example.R.layout.view_users

class UsersFragment: MvpAppCompatFragment(view_users), UsersView, UsersAdapter.Delegate {

    companion object {

        fun newInstance(): Fragment =
            UsersFragment()
                .arguments()

    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = GitHubUserRepositoryFactory.create(),
            router = router
        )
    }

    private val viewBinding: ViewUsersBinding by viewBinding()
    private val usersAdapter = UsersAdapter(delegate = this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.users.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUser>) {
        usersAdapter.submitList(users)
    }

    override fun onUserPicked(user: GitHubUser) =
        presenter.displayUser(user)


}

