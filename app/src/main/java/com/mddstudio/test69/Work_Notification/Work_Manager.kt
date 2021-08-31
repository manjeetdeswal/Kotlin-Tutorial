package com.mddstudio.test69.Work_Notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.work.*
import com.mddstudio.test69.R
import java.util.concurrent.TimeUnit

class Work_Manager : AppCompatActivity() {
    private lateinit var workbuton:Button
    private lateinit var worktext:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        worktext=findViewById(R.id.worktest)
        workbuton=findViewById(R.id.workmag)
        workbuton.setOnClickListener {
            //setonetimework()
            setperodicreq()
        }

    }
    private fun setonetimework(){
        val constraint=Constraints.Builder()
            .setRequiresCharging(true)
            .build()
        val data=Data.Builder().putInt("key",325).build()

        val workinstace=WorkManager.getInstance(applicationContext)
        val oneTimeWorkRequest=OneTimeWorkRequest.Builder(Uploadworker::class.java)
            .setConstraints(constraint)
            .setInputData(data)
            .build()

        val filterreues=OneTimeWorkRequest.Builder(FiletringWork::class.java)
            .build()
        val compress=OneTimeWorkRequest.Builder(CompressWorker::class.java)
            .build()
        val downloadwork=OneTimeWorkRequest.Builder(DownloadWork::class.java)
            .build()

        val parlelwok= mutableListOf<OneTimeWorkRequest>()

        parlelwok.add(downloadwork)
        parlelwok.add(filterreues)



        workinstace.beginWith(parlelwok)
            .then(compress).then(oneTimeWorkRequest)
            .enqueue()
        workinstace.getWorkInfoByIdLiveData(oneTimeWorkRequest.id).observe(this, Observer {
            worktext.text=it.toString()
            if(it.state.isFinished){
                val dat=it.outputData
                val message=dat.getString("key1")
                Toast.makeText(this,message,Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun setperodicreq(){
        val peroidcreques=PeriodicWorkRequest.Builder(DownloadWork::class.java,16,TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(applicationContext).enqueue(peroidcreques)
    }
}