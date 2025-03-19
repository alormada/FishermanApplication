package com.example.myfishermanapplication.model

import androidx.compose.ui.text.font.FontWeight
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.util.UUID

@Entity
@JsonClass(generateAdapter = true)
data class Fish(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
//    val title: String,
    val location: String,
    val weight: Float,
): Serializable
