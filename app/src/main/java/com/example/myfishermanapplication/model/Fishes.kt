package com.example.myfishermanapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.util.UUID

@Entity
@JsonClass(generateAdapter = true)
data class Fish(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val type: String,
//    val title: String,
    val description: String,
): Serializable
