package com.example.mvp_example.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

    @Entity(tableName = "github_user_repo")
    data class GitHubUserRepo(
        @PrimaryKey
        @SerializedName("id")
        val id: String,
        @ColumnInfo(name = "name")
        @SerializedName("name")
        val name: String,
    )