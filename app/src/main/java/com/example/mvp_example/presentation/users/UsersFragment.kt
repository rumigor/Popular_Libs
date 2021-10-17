package com.example.mvp_example.presentation.users

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mvp_example.App
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.example.mvp_example.arguments
import com.example.mvp_example.databinding.ViewUsersBinding
import com.example.mvp_example.presentation.users.adapter.UsersAdapter
import com.example.mvp_example.R.layout.view_users
import com.example.mvp_example.data.di.GitHubUsersComponent
import com.example.mvp_example.presentation.GitHubUserViewModel
import com.example.mvp_example.scheduler.Schedulers
import com.example.mvp_example.data.users.GitHubUsersRepository
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class UsersFragment: MvpAppCompatFragment(view_users), UsersView, UsersAdapter.Delegate {

    companion object {

        fun newInstance(): Fragment =
            UsersFragment()
                .arguments()

    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var schedulers: Schedulers

    @Inject
    lateinit var gitHubUserRepository: GitHubUsersRepository

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            userRepository = gitHubUserRepository,
            router = router,
            schedulers = schedulers
        )
    }

    private val viewBinding: ViewUsersBinding by viewBinding()
    private val usersAdapter = UsersAdapter(delegate = this)

    private var gitHubUsersComponent: GitHubUsersComponent? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        gitHubUsersComponent =
            (requireActivity().application as? App)
                ?.gitHubApplicationComponent
                ?.gitHubUsersComponent()
                ?.build()
                ?.also { it.inject(this) }
    }

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

    override fun onDestroy() {
        super.onDestroy()
        gitHubUsersComponent = null
    }

}

