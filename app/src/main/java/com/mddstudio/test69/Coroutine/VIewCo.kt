package com.mddstudio.test69.Coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mddstudio.test69.R

class VIewCo : AppCompatActivity() {
    private lateinit var maninmo:MyVIewMOdel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_co)
        maninmo=ViewModelProvider(this).get(MyVIewMOdel::class.java)
//        maninmo.getuser()
        maninmo.users.observe(this, Observer {
            myuesr->
            myuesr.forEach{
                Log.i("afm","name is ${it.name}")
            }
        })

    }
}