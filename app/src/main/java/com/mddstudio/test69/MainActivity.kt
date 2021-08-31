package com.mddstudio.test69

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mddstudio.test69.livedata.ViewModel
import com.mddstudio.test69.livedata.ViewModel2
import com.mddstudio.test69.livedata.ViewModel3
import com.mddstudio.test69.databinding.ActivityMainBinding
import com.mddstudio.test69.room.roomDb
import com.mddstudio.test69.data_Bind.DataBinding
import com.mddstudio.test69.data_Bind.DataBinding2
import com.mddstudio.test69.data_Bind.DataBinding3
import com.mddstudio.test69.Coroutine.VIewCo
import com.mddstudio.test69.Coroutine.async
import com.mddstudio.test69.Coroutine.courutine
import com.mddstudio.test69.Work_Notification.Notifiaction
import com.mddstudio.test69.Retrofit.Retrof
import com.mddstudio.test69.Fm_Recy.recyView
import com.mddstudio.test69.Work_Notification.Work_Manager
import com.mddstudio.test69.noti.Show

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.apply {
            button1.setOnClickListener {
                startActivity(Intent(this@MainActivity, DataBinding::class.java))
            }
            button2.setOnClickListener {
                startActivity(Intent(this@MainActivity, DataBinding2::class.java))
            }
            button3.setOnClickListener {
                startActivity(Intent(this@MainActivity, DataBinding3::class.java))
            }
            button4.setOnClickListener {
                startActivity(Intent(this@MainActivity, ViewModel::class.java))
            }
            button5.setOnClickListener {
                startActivity(Intent(this@MainActivity, ViewModel2::class.java))
            }
            button6.setOnClickListener {
                startActivity(Intent(this@MainActivity, ViewModel3::class.java))
            }

            button8.setOnClickListener {
                startActivity(Intent(this@MainActivity, recyView::class.java))
            }
            button9.setOnClickListener {
                startActivity(Intent(this@MainActivity, courutine::class.java))
            }
            button10.setOnClickListener {
                startActivity(Intent(this@MainActivity, async::class.java))
            }
            button11.setOnClickListener {
                startActivity(Intent(this@MainActivity, VIewCo::class.java))
            }
            button12.setOnClickListener {
                startActivity(Intent(this@MainActivity, roomDb::class.java))
            }
            button13.setOnClickListener {
                startActivity(Intent(this@MainActivity, Retrof::class.java))
            }
            button14.setOnClickListener {
                startActivity(Intent(this@MainActivity, Notifiaction::class.java))
            }
            button15.setOnClickListener {
                startActivity(Intent(this@MainActivity, Work_Manager::class.java))
            }
            button16.setOnClickListener {
                startActivity(Intent(this@MainActivity, Show::class.java))
            }

        }






    }


}