package com.example.mvp_example.presentation.users

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvp_example.App.Navigation.router
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.mvp_example.arguments
import com.example.mvp_example.data.user.GitHubUser
import com.example.mvp_example.data.user.GitHubUserRepositoryFactory
import com.example.mvp_example.databinding.ViewUsersBinding
import com.example.mvp_example.presentation.users.adapter.UsersAdapter
import com.example.mvp_example.R.layout.view_users
import com.example.mvp_example.presentation.GitHubUserViewModel
import com.example.mvp_example.scheduler.SchedulersFactory

class UsersFragment: MvpAppCompatFragment(view_users), UsersView, UsersAdapter.Delegate {

    companion object {

        fun newInstance(): Fragment =
            UsersFragment()
                .arguments()

    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = GitHubUserRepositoryFactory.create(),
            router = router,
            schedulers = SchedulersFactory.create()
        )
    }

    private val viewBinding: ViewUsersBinding by viewBinding()
    private val usersAdapter = UsersAdapter(delegate = this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.users.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUserViewModel>) {
        usersAdapter.submitList(users)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onUserPicked(user: GitHubUserViewModel) =
        presenter.displayUser(user)

}

