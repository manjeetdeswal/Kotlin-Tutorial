package com.mddstudio.test69.Work_Notification

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class FiletringWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        try {
            for (i in 0..3000){
                Log.i("magva", "Filtering" +i.toString())
            }


            return Result.success()

        }catch (e: Exception){
            return Result.failure()
        }
    }
}