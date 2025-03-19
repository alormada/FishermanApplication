package com.example.myfishermanapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myfishermanapplication.model.Fish


@Dao
interface FishDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(fishes: List<Fish>)

    @Query("SELECT * FROM fish")
    suspend fun getAll(): List<Fish>
}
