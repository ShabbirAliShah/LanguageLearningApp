package com.example.prototype

import androidx.room.Database
import androidx.room.RoomDatabase

//@Database(entities = [CountryLanguages::class], version = 1)
//abstract class AppDatabase : RoomDatabase() {
//    abstract fun AppDao(): AppDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "app_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
//}
@Database(entities = [CountryEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}
