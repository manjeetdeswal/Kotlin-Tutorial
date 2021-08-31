package com.mddstudio.test69.room

class Rapos (private val dao: SubDao) {
    val subscriber=dao.getallData1()
    suspend fun insert(subscriber: Subscriber):Long{
       return dao.insertdata(subscriber)
    }
    suspend fun update(subscriber: Subscriber):Int{
        return  dao.updatadata(subscriber)
    }
    suspend fun delete(subscriber: Subscriber):Int{
        return dao.deletedata(subscriber)
    }
     suspend fun deleteall():Int{
       return dao.deletall1()
    }
    fun getrall(){
        dao.getallData1()
    }
}