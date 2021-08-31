package com.mddstudio.test69.Coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mddstudio.test69.R
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class async : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)
        CoroutineScope(IO).launch {
            Log.i("myt","Cal Started")
           val soc1=async { getsock1() }
            val soc12= async { getsock12() }
            val total=soc1.await()+soc12.await()
            Log.i("myt",total.toString())
        }

    }
    private suspend fun getsock1(): Int {
        delay(5000)
        Log.i("myt","Stock 1 returned")
        return 55000
    }
    private suspend fun getsock12(): Int {
        delay(8000)
        Log.i("myt","Stock 2 returned")
        return 55000
    }


}