package com.example.myfishermanapplication.database

import androidx.room.*
import com.example.myfishermanapplication.model.Catch
import kotlinx.coroutines.flow.Flow

@Dao
interface CatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCatch(catch: Catch)

    @Update
    suspend fun updateCatch(catch: Catch)

    @Delete
    suspend fun deleteCatch(catch: Catch)

    @Query("SELECT * FROM `Catch`")
    fun getAllCatches(): Flow<List<Catch>>

    @Query("SELECT * FROM `Catch` WHERE id = :id")
    suspend fun getCatchById(id: String): Catch?
}
