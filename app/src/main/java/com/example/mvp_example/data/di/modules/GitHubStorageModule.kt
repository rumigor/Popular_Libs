package com.example.mvp_example.data.di.modules

import android.content.Context
import androidx.room.Room
import com.example.mvp_example.data.di.InMemory
import com.example.mvp_example.data.di.Persisted
import com.example.mvp_example.data.storage.GitHubStorage
import com.example.mvp_example.data.storage.migration.GitHub1to2Migration
import com.example.mvp_example.data.storage.migration.GitHub2to3Migration
import dagger.Module
import dagger.Provides

@Module
class GitHubStorageModule {

    @Persisted
    @Provides
    fun provideGitHubDatabaseStorage(context: Context): GitHubStorage =
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .addMigrations(GitHub1to2Migration, GitHub2to3Migration)
            .build()

    @InMemory
    @Provides
    fun provideGitHubInMemoryDatabaseStorage(context: Context): GitHubStorage =
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()

}