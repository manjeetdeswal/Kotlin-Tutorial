package com.mddstudio.test69.Work_Notification

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class CompressWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        try {
            for (i in 0..300){
                Log.i("magva", "Compressing" +i.toString())
            }


            return Result.success()

        }catch (e: Exception){
            return Result.failure()
        }
    }
}