package com.mddstudio.test69.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mddstudio.test69.R
import com.mddstudio.test69.databinding.ActivityViewModel3Binding

class ViewModel3 : AppCompatActivity() {
    private lateinit var binding: ActivityViewModel3Binding
    private lateinit var viewmodel:ThirdModel
    private lateinit var viemodelfactort:ThirdFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_view_model3)
        viemodelfactort=ThirdFactory(150)
        viewmodel= ViewModelProvider(this,viemodelfactort).get(ThirdModel::class.java)

        viewmodel.totaldat.observe(this){
           binding.resultTextView.text=it.toString()
        }

        binding.apply {

            binding.insertButton.setOnClickListener {
                viewmodel.gettotalsum(Integer.parseInt(inputEditText.text.toString()))
               // resultTextView.text=viewmodel.getsum().toString()
            }
        }
    }
}


