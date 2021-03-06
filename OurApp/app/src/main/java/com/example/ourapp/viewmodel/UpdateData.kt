package com.example.ourapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ourapp.DataDatabase
import com.example.ourapp.DataRepository
import com.example.ourapp.Home
import com.example.ourapp.MyModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateData : ViewModel() {
    lateinit var repository: DataRepository
    fun init(context: Context) {
        val myFriendDao = DataDatabase.getDatabase(context).myFriendDao()
        repository = DataRepository(myFriendDao)
    }
    fun updateData(myFriend: MyModel) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(myFriend)
        }
}