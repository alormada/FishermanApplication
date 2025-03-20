package com.example.myfishermanapplication.model


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.util.UUID
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Fish(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
//    val title: String,
    val length: String,
    val bait: String,
    val protectiveDimension : String,
    val description: String
): Parcelable
