package com.mddstudio.test69.Work_Notification

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class Uploadworker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        try {
            val count=inputData.getInt("key",9)
            for (i in 0 until count){
                Log.i("magva",i.toString())
            }

            val time=SimpleDateFormat("dd/mm/yyyy hh:mm:ss")
            val curedate=time.format(Date())
            val ouputdata=Data.Builder().putString("key1",curedate).build()
            return Result.success(ouputdata)

        }catch (e:Exception){
            return Result.failure()
        }
    }
}