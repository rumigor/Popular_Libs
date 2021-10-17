package com.example.mvp_example.data.di

import com.example.mvp_example.data.di.modules.ReposModule
import com.example.mvp_example.presentation.repos.ReposFragment
import dagger.Subcomponent

@Repos
@Subcomponent(modules = [ReposModule::class])
interface ReposComponent {
    fun inject(reposFragment: ReposFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ReposComponent
    }
}