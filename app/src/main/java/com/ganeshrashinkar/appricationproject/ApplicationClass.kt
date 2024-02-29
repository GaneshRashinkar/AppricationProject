package com.ganeshrashinkar.appricationproject

import android.app.Application
import com.ganeshrashinkar.appricationproject.database.UsersDatabase
import com.ganeshrashinkar.appricationproject.database.repository.UserRepository

class ApplicationClass:Application() {
    val database:UsersDatabase by lazy { UsersDatabase.getDatabase(this) }
    val userRepository:UserRepository by lazy { UserRepository(database.userDao()) }
}