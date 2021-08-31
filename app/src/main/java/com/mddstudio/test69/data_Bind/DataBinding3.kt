package com.mddstudio.test69.data_Bind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mddstudio.test69.R
import com.mddstudio.test69.databinding.ActivityDataBinding3Binding


class DataBinding3 : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding3)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_data_binding3)

        val student:Student= Student("1","abc@gmail.com","Manjeet")
        binding.student=student

        //binding.emailText.text
        //binding.nameText.text
    }
}