package com.example.myfishermanapplication.database

import androidx.room.Dao
import androidx.room.Query
import com.example.myfishermanapplication.model.Fish


@Dao
interface FishDao {

    @Query("SELECT * FROM fish")
    suspend fun getAll(): List<Fish>

}