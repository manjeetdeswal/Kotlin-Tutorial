package com.mddstudio.test69.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mddstudio.test69.R
import com.mddstudio.test69.databinding.ActivityViewModelBinding

open class ViewModel : AppCompatActivity() {
    private lateinit var binding:ActivityViewModelBinding
    private lateinit var viewmodel: MainModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_view_model)
        viewmodel=ViewModelProvider(this).get(MainModel::class.java)
        binding.lifecycleOwner=this
        binding.myview=viewmodel



    }
}