package com.example.mvp_example.data.storage

import android.content.Context
import androidx.room.Room
import com.example.mvp_example.data.storage.migration.GitHub1to2Migration
import com.example.mvp_example.data.storage.migration.GitHub2to3Migration

object GitHubStorageFactory {

    fun create(context: Context): GitHubStorage =
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .addMigrations(GitHub1to2Migration, GitHub2to3Migration)
            .build()

    fun createInMemory(context: Context): GitHubStorage =
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()

}