package com.ganeshrashinkar.appricationproject.viemodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ganeshrashinkar.appricationproject.database.eitities.UserClass
import com.ganeshrashinkar.appricationproject.database.repository.UserRepository
import kotlinx.coroutines.launch

class UsersViewmodel(val repository: UserRepository):ViewModel() {
    val allUsers:LiveData<MutableList<UserClass>> = repository.getAllUsers().asLiveData()

    fun insert(user:UserClass) = viewModelScope.launch {
        repository.insert(user)
    }
}

class UsersViewmodelFactory(val repository: UserRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UsersViewmodel::class.java)){
            return UsersViewmodel(repository) as T
        }
        throw ClassCastException("class cast exception")
    }
}