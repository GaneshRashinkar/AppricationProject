package com.ganeshrashinkar.appricationproject.database.repository

import com.ganeshrashinkar.appricationproject.database.dao.UserDao
import com.ganeshrashinkar.appricationproject.database.eitities.UserClass
import kotlinx.coroutines.flow.Flow


class UserRepository(val userDao: UserDao) {

    suspend fun insert(user:UserClass)=userDao.insert(user)

    fun getAllUsers(): Flow<MutableList<UserClass>> = userDao.getAllUsers()
}