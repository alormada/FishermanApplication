package com.example.myfishermanapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myfishermanapplication.model.Fish


@Database(entities = [Fish::class], version = 6)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fishDao(): FishDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(DatabaseCallback())
                    .build()
                INSTANCE = instance // ← bardzo ważna linijka!
                instance
            }
        }

        private class DatabaseCallback : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                CoroutineScope(Dispatchers.IO).launch {
                    populateDatabase(INSTANCE!!.fishDao())
                }
            }
        }

        suspend fun populateDatabase(fishDao: FishDao) {
            val predefinedFishes = listOf(
                Fish(name = "Karp", location = "Jezioro Śniardwy", weight = 5.2f),
                Fish(name = "Szczupak", location = "Wisła", weight = 3.1f),
                Fish(name = "Leszcz", location = "Odra", weight = 1.8f)
            )
            fishDao.insertAll(predefinedFishes)
        }
    }
}




