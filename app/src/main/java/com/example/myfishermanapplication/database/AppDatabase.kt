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


@Database(entities = [Fish::class], version = 8)
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
//                Fish(name = "Karp", location = "Jezioro Śniardwy", weight = 5.2f),
//                Fish(name = "Szczupak", location = "Wisła", weight = 3.1f),
//                Fish(name = "Leszcz", location = "Odra", weight = 1.8f),
                Fish(name = "Boleń", length = "50", bait= "Woblery, obrotówki, gumy", protectiveDimension = "40", description = "Drapieżnik z rodziny karpiowatych, szybki i waleczny."),
                Fish(name = "Boleń", length = "50", bait= "Woblery, obrotówki, gumy", protectiveDimension = "40", description = "Drapieżnik z rodziny karpiowatych, szybki i waleczny."),
                Fish(name = "Jesiotr", length = "150", bait= "Rosówki, martwa rybka", protectiveDimension = "70", description = "Duża ryba o wydłużonym ciele, rzadko spotykana w naturalnych wodach."),
                Fish(name = "Karaś srebrzysty", length = "35", bait= "Ciasto, kukurydza, czerwone robaki", protectiveDimension = "15", description = "Podobny do karasia złocistego, lecz ma srebrzystą barwę."),
                Fish(name = "Karaś złocisty", length = "30", bait= "Ciasto, kukurydza, czerwone robaki", protectiveDimension = "15", description = "Popularna ryba spokojnego żeru o złocistej łusce."),
                Fish(name = "Karp", length = "90", bait= "Kulki proteinowe, kukurydza, pellet", protectiveDimension = "30", description = "Popularna ryba hodowlana, ceniona w wędkarstwie sportowym."),
                Fish(name = "Kleń", length = "50", bait= "Chleb, woblery, czerwone robaki", protectiveDimension = "25", description = "Silna ryba z rodziny karpiowatych, spotykana w rzekach i jeziorach."),
                Fish(name = "Leszcz", length = "60", bait= "Białe robaki, kukurydza, ciasto", protectiveDimension = "25", description = "Ryba spokojnego żeru, często łowiona przez wędkarzy spławikowych."),
                Fish(name = "Lin", length = "50", bait= "Rosówki, kukurydza, ciasto", protectiveDimension = "25", description = "Charakterystyczna zielonkawo-złota ryba z małymi łuskami."),
                Fish(name = "Okoń", length = "40", bait= "Twistery, obrotówki, rosówki", protectiveDimension = "15", description = "Drapieżnik o zielonkawym ubarwieniu i czerwonych płetwach."),
                Fish(name = "Pstrąg potokowy", length = "55", bait= "Woblery, błystki, muchy", protectiveDimension = "30", description = "Szybka, drapieżna ryba zamieszkująca górskie potoki."),
                Fish(name = "Pstrąg tęczowy", length = "60", bait= "Woblery, błystki, muchy", protectiveDimension = "30", description = "Introdukowana ryba drapieżna, popularna w hodowlach i łowiskach specjalnych."),
                Fish(name = "Sandacz", length = "100", bait= "Gumy, woblery, martwa rybka", protectiveDimension = "45", description = "Drapieżnik z rodziny okoniowatych, ceniony przez wędkarzy."),
                Fish(name = "Sielawa", length = "40", bait= "Ochotka, białe robaki", protectiveDimension = "25", description = "Ryba zimnowodna, smukła i srebrzysta, spotykana w czystych jeziorach."),
                Fish(name = "Sum", length = "250", bait= "Martwa rybka, wątroba, rosówki", protectiveDimension = "70", description = "Największa drapieżna ryba słodkowodna w Polsce, osiągająca ogromne rozmiary."),
                Fish(name = "Szczupak", length = "150", bait= "Woblery, gumy, martwa rybka", protectiveDimension = "45", description = "Najpopularniejszy drapieżnik w Polsce, znany z nagłych ataków."),
                Fish(name = "Troć wędrowna", length = "90", bait= "Woblery, błystki, muchy", protectiveDimension = "50", description = "Wędrowna ryba łososiowata, spotykana w rzekach i Bałtyku."),
                Fish(name = "Węgorz", length = "150", bait= "Rosówki, martwa rybka, wątroba", protectiveDimension = "70", description = "Wężokształtna ryba nocna, ceniona za smaczne mięso."),
                Fish(name = "Wzdręga", length = "40", bait= "Ciasto, kukurydza, białe robaki", protectiveDimension = "15", description = "Ryba o czerwonych płetwach, przypominająca płoć."),
                Fish(name = "Zander", length = "100", bait= "Gumy, woblery, martwa rybka", protectiveDimension = "45", description = "Drapieżnik podobny do sandacza, często mylony z nim."),
                Fish(name = "Żółtacz", length = "35", bait= "Białe robaki, czerwone robaki, ciasto", protectiveDimension = "20", description = "Rzadka ryba słodkowodna, występująca w czystych wodach."),
                )
            fishDao.insertAll(predefinedFishes)
        }
    }
}




