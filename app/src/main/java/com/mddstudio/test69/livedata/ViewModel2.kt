package com.mddstudio.test69.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mddstudio.test69.R
import com.mddstudio.test69.databinding.ActivityViewModel2Binding

class ViewModel2 : AppCompatActivity() {
    private lateinit var binding:ActivityViewModel2Binding
    private lateinit var viewmodel:SecModel
    private lateinit var viemodelfactort:SecFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model2)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_view_model2)
        viemodelfactort=SecFactory(150)
        viewmodel=ViewModelProvider(this,viemodelfactort).get(SecModel::class.java)

        binding.apply {
resultTextView.text=viewmodel.getsum().toString()
            binding.insertButton.setOnClickListener {
                viewmodel.gettotalsum(Integer.parseInt(inputEditText.text.toString()))
                resultTextView.text=viewmodel.getsum().toString()
            }
        }
    }
}