package com.mddstudio.test69.livedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class ThirdFactory(private  val startValue:Int) :ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ThirdModel::class.java)){
            return ThirdModel(startValue) as T
        }
        throw IllegalArgumentException("UNknown View Model")
    }
}