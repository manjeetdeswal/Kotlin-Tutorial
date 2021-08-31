package com.mddstudio.test69.data_Bind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mddstudio.test69.R
import com.mddstudio.test69.databinding.ActivityDataBindingBinding


class DataBinding : AppCompatActivity() {
    private lateinit var binding: ActivityDataBindingBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        binding.submitButton.setOnClickListener {
            display()
        }


    }

    private fun display() {
        binding.apply {
            greetingTextView.text = "Hello" + nameEditText.text
        }
    }
}