package com.mddstudio.test69.livedata

import androidx.lifecycle.ViewModel

class SecModel(startValue:Int) :ViewModel() {
    private var sum=0
    init {
        sum=startValue
    }
    fun getsum():Int{
        return sum
    }
    fun gettotalsum(input:Int){
           sum +=input
    }


}