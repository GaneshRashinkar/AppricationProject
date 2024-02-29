package com.ganeshrashinkar.appricationproject.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ganeshrashinkar.appricationproject.database.eitities.UserClass
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user:UserClass)

    @Query("select * from userclass")
    fun getAllUsers():Flow<MutableList<UserClass>>
}