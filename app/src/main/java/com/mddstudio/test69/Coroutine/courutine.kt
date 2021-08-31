package com.mddstudio.test69.Coroutine

import android.app.NotificationManager
import android.app.RemoteInput
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import com.google.android.material.snackbar.Snackbar
import com.mddstudio.test69.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class courutine : AppCompatActivity() {
    private var count=0
    private lateinit var btnCount:Button
    private lateinit var tvCount:TextView
    private lateinit var tvUserMessage:TextView
    private lateinit var newtext:TextView

    private lateinit var btnDownloadUserData:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courutine)



        btnCount=findViewById(R.id.btnCount)
        tvUserMessage=findViewById(R.id.tvUserMessage)
        tvCount=findViewById(R.id.tvCount)
        btnDownloadUserData=findViewById(R.id.btnDownloadUserData)
        newtext=findViewById(R.id.newtext)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
        recreinput()
    }
    private fun recreinput(){
        val intent=this.intent
        val remote= RemoteInput.getResultsFromIntent(intent)
        if (remote!=null){
            val key="reply"
            val inputst=remote.getCharSequence(key).toString()
            Snackbar.make(newtext,inputst.toString(), Snackbar.LENGTH_LONG).show()
            newtext.text=inputst
             val channelid="Manjeet"
            val notidicatid=69
            val repliednoti=NotificationCompat.Builder(this,channelid).setSmallIcon(android.R.drawable.arrow_down_float)
                .setContentText("Your reply recievrer").build()

            val notficaton=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notficaton.notify(notidicatid,repliednoti)
        }
    }

    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            withContext(Dispatchers.Main){
                tvUserMessage.text="Downloading user $i in ${Thread.currentThread().name}"
            }


        }
    }
}