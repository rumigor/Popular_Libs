package com.example.mvp_example.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvp_example.data.storage.user.GitHubUserDao
import com.example.mvp_example.data.user.GitHubUser

@Database(exportSchema = false, entities = [GitHubUser::class], version = 3)
abstract class GitHubStorage : RoomDatabase() {

    abstract fun gitHubUserDao(): GitHubUserDao

}