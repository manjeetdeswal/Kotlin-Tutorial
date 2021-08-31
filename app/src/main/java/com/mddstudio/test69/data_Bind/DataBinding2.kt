package com.mddstudio.test69.data_Bind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mddstudio.test69.R
import com.mddstudio.test69.databinding.ActivityDataBinding2Binding

class DataBinding2 : AppCompatActivity() {
    private lateinit var binding2: ActivityDataBinding2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2=DataBindingUtil.setContentView(this,R.layout.activity_data_binding2)
        binding2.controlButton.setOnClickListener{
            diaplay()
        }

    }

    private fun diaplay() {
       binding2.apply {
           if (progressBar.visibility== View.GONE){
               progressBar.visibility=View.VISIBLE
               controlButton.text="Stop"
           }else{
               progressBar.visibility=View.GONE
               controlButton.text="Start"
           }
       }
    }
}