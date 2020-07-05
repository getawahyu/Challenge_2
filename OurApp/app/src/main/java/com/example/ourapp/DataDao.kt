package com.example.ourapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DataDao {
    @Query("SELECT * from my_data")
    fun getAllMyFriend(): LiveData<List<Home>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(myFriend: Home)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(myFriends: List<Home>)
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(myFriend: Home)
    @Delete()
    suspend fun delete(myFriend: Home)
    @Query("DELETE FROM my_data")
    suspend fun deleteAll()
}