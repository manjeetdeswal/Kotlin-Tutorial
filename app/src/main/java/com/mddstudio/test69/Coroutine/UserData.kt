package com.mddstudio.test69.Coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class UserData {
lateinit var deffered:Deferred<Int>
    suspend fun gettotaluser():Int{
        var count=0
        coroutineScope {
             launch(IO) {
                 delay(1000)
                 count=50
             }
           /*  deffered=async(Dispatchers.IO) {
               delay(3000)
               return@async 70
             }*/
             }
        return count
        }

    }
