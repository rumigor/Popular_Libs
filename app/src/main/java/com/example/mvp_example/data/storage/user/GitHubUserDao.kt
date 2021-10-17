package com.example.mvp_example.data.storage.user

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.mvp_example.data.model.GitHubUser
import com.example.mvp_example.data.model.Repository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM github_user")
    fun fetchUsers(): Observable<List<GitHubUser>>

    @Query("SELECT * FROM github_user WHERE login LIKE :login LIMIT 1")
    fun fetchUserByLogin(login: String): Single<GitHubUser>

    @Query("SELECT * FROM github_repository")
    fun fetchRepos(): Single<List<Repository>>


    @Insert(onConflict = REPLACE)
    fun retainRepos(repos: List<Repository>): Completable

    @Update(onConflict = REPLACE)
    fun retainRepos(repository: Repository): Completable

    @Insert(onConflict = REPLACE)
    fun retain(users: List<GitHubUser>): Completable

    @Update(onConflict = REPLACE)
    fun retain(user: GitHubUser): Completable
}
