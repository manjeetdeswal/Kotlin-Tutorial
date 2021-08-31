package com.mddstudio.test69.Work_Notification

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class DownloadWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        try {
            for (i in 0..3000){
                Log.i("magva", "Downlaod" +i.toString())
            }
            val time= SimpleDateFormat("dd/mm/yyyy hh:mm:ss")
            val curedate=time.format(Date())
            Log.i("vsbsb", "Completed in $curedate")

            return Result.success()

        }catch (e: Exception){
            return Result.failure()
        }
    }
}