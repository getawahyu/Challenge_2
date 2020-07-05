package com.example.ourapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ourapp.Home
import com.example.ourapp.DataDao

@Database(entities = arrayOf(MyModel::class), version = 2, exportSchema = false)
public abstract class DataDatabase : RoomDatabase() {
    abstract fun myFriendDao(): DataDao
    companion object {
        // Singleton prevents multiple instances of database opening at the
// same time.
        @Volatile
        private var INSTANCE: DataDatabase? = null
        fun getDatabase(context: Context): DataDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataDatabase::class.java,
                    "my_friend_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}