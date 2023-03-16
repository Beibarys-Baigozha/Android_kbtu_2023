package com.example.test

import android.content.Context
import androidx.room.*

@Database(entities = [Student::class], version = 1)
abstract class DBmanager : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: DBmanager? = null

        fun getDatabase(context: Context): DBmanager {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DBmanager::class.java,
                    "app_db"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}