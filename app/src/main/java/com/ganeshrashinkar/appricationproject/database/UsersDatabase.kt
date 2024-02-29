package com.ganeshrashinkar.appricationproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.ganeshrashinkar.appricationproject.database.dao.UserDao
import com.ganeshrashinkar.appricationproject.database.eitities.UserClass

@Database(entities = arrayOf(UserClass::class), version = 1)
abstract class UsersDatabase: RoomDatabase() {

 abstract fun userDao():UserDao

companion object{
@Volatile
private var INSTANCE:UsersDatabase? =null
        fun getDatabase(context:Context):UsersDatabase{
        return INSTANCE?: synchronized(this){
            val instance= Room.databaseBuilder(context.applicationContext,
                UsersDatabase::class.java,"UsersDb").
                    build()

            INSTANCE=   instance
            return instance
        }
        }
}
}