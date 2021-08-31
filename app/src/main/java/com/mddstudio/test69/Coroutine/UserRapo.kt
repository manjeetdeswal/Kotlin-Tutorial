package com.mddstudio.test69.Coroutine

import kotlinx.coroutines.delay

class UserRapo {
    suspend fun getusers():List<User> {
        delay(2000)
        val list:List<User> = listOf(
            User(1,"Man"),
                    User(2,"Ban"),
            User(3,"Ran"),
            User(4,"Nan")
        )
        return list
    }
}