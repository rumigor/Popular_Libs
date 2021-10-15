package com.example.mvp_example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github_repository")
data class Repository(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,
//    @ColumnInfo(name = "avatar")
//    @SerializedName("avatar_url")
//    val avatar: String,
//    @ColumnInfo(name = "migrate")
//    val migrate: String?,
)