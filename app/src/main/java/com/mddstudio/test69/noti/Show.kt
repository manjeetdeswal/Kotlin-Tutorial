package com.mddstudio.test69.noti

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import com.mddstudio.test69.Coroutine.courutine
import com.mddstudio.test69.R
import com.mddstudio.test69.Retrofit.Retrof

class Show : AppCompatActivity() {
    private lateinit var notbuuttom: Button
    private val channelid="Manjeet"
    private var notificationManager: NotificationManager?=null
    private val key="reply"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notbuuttom = findViewById(R.id.notbutton)
        createchannel(channelid,"MAnjeet","Hello World")

        notbuuttom.setOnClickListener {
            display()

        }
    }

    private fun display() {
        val notidicatid=69
        val tapindet= Intent(this, courutine::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this,0,tapindet, PendingIntent.FLAG_UPDATE_CURRENT)


        val tapindet1= Intent(this, Retrof::class.java)
        val pendingIntent1: PendingIntent =
            PendingIntent.getActivity(this,0,tapindet1, PendingIntent.FLAG_UPDATE_CURRENT)
        val action=
            NotificationCompat.Action.Builder(R.mipmap.ic_launcher_round,"Manjeet",pendingIntent1).build()
//reply code
        val remote= androidx.core.app.RemoteInput.Builder(key).run {
            setLabel("INsert youe name")
            build()
        }
        val replyaction : NotificationCompat.Action= NotificationCompat.Action.Builder(
            R.drawable.ic_launcher_foreground,
            "Reply", pendingIntent,).addRemoteInput(remote).build()


        val tapindet3= Intent(this, courutine::class.java)
        val pendingIntent3: PendingIntent =
            PendingIntent.getActivity(this,0,tapindet3, PendingIntent.FLAG_UPDATE_CURRENT)
        val action1=
            NotificationCompat.Action.Builder(R.mipmap.ic_launcher_round,"Deswal",pendingIntent3).build()


        val notifiaction= NotificationCompat.Builder(this,channelid)
            .setContentTitle("sbsfbsf")
            .setContentText("cmskvn ksfn vfvs")
            .setPriority(NotificationCompat.PRIORITY_HIGH).setSmallIcon(R.drawable.ic_launcher_background)
            .setAutoCancel(true)
            .addAction(action)
            .addAction(action1)
            .addAction(replyaction)
            .build()
        notificationManager?.notify(notidicatid,notifiaction)
    }
    private fun createchannel( id:String,name: String,desc:String){
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val importance=NotificationManager.IMPORTANCE_HIGH
            val channel= NotificationChannel(id,name,importance)
            channel.description=desc
            notificationManager?.createNotificationChannel(channel)
        }

    }
}