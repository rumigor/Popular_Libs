package com.example.mvp_example.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvp_example.data.model.GitHubUser
import com.example.mvp_example.data.model.Repository
import com.example.mvp_example.data.storage.user.GitHubUserDao

@Database(exportSchema = false, entities = [GitHubUser::class, Repository::class], version = 3)
abstract class GitHubStorage : RoomDatabase() {

    abstract fun gitHubUserDao(): GitHubUserDao

}