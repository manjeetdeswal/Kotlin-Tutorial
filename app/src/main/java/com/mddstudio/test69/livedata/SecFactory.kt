package com.mddstudio.test69.livedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SecFactory( private  val startValue:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SecModel::class.java)){
            return SecModel(startValue) as T
        }
        throw IllegalArgumentException("UNknown View Model")
    }
}