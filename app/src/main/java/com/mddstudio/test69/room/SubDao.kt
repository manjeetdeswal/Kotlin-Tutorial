package com.mddstudio.test69.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubDao {


    @Insert
    suspend fun insertdata(subscriber: Subscriber):Long
    @Update
    suspend fun updatadata(subscriber: Subscriber):Int
    @Delete
    suspend fun deletedata(subscriber: Subscriber):Int



    @Query("SELECT * from Subs")
     fun getallData1():LiveData<List<Subscriber>>

    @Query("Delete  from Subs")
    fun deletall1():Int


}