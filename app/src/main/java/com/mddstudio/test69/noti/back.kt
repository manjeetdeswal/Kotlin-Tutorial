package com.mddstudio.test69.noti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.google.android.material.timepicker.TimeFormat
import com.mddstudio.test69.R
import java.sql.Time
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

abstract class back : AppCompatActivity() {
    private lateinit var workbuton: Button
    private lateinit var worktext: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back2)



        workbuton = findViewById(R.id.notbutton)





        workbuton.setOnClickListener {

             setperodicreq()


        }
    }

    private fun setperodicreq(){

        val peroidcreques= PeriodicWorkRequest.Builder(notiwork::class.java,720, TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(applicationContext).enqueue(peroidcreques)
    }
}