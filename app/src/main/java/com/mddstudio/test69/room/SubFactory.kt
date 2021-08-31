package com.mddstudio.test69.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SubFactory (private var rapo:Rapos):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubViewModel::class.java)){
            return SubViewModel(rapo) as T
        }
        throw IllegalArgumentException("UNknown MOedlav  a sf ")
    }

}