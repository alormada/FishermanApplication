package com.example.myfishermanapplication.database

import androidx.room.Room
import android.content.Context

object DatabaseConfiguration {

    fun getDatabase(context: Context) = Room.databaseBuilder(
        context, AppDatabase::class.java, "fishes-database"
    ).build()
}

