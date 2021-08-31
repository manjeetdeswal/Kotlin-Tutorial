package com.mddstudio.test69.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subscriber::class],version = 1)
abstract class SubData : RoomDatabase() {
    abstract val subDao:SubDao

    companion object{
        @Volatile
        private  var Instance:SubData?=null
        fun getINstance(context:Context):SubData{
            synchronized(this){
                var instance= Instance
                if (instance==null){
                    instance=Room.databaseBuilder(context.applicationContext,
                    SubData::class.java,"SubData").build()
                }
                return instance
            }

        }

    }

}