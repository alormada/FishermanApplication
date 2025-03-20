package com.example.myfishermanapplication.database

import com.example.myfishermanapplication.model.Fish

class FishDatabaseRepository(private val db: AppDatabase) {

    suspend fun getAllFish(): List<Fish> {
        return db.fishDao().getAll()
    }

    suspend fun getFishById(fishId: String): Fish? {
        return db.fishDao().getFishById(fishId)
    }

}


