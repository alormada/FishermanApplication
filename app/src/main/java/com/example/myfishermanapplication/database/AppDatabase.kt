package com.example.myfishermanapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfishermanapplication.model.Fish

@Database(entities = [Fish::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fishDao(): FishDao
}