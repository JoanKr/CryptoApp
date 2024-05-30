package com.example.cryptoapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CryptoPriceEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cryptoPriceDao(): CryptoPriceDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                    .build().also { instance = it }
            }
    }
}
