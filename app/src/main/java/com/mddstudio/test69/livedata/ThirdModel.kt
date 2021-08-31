package com.mddstudio.test69.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ThirdModel(startValue:Int) : ViewModel() {
    private var sum= MutableLiveData<Int>()
    val totaldat:LiveData<Int>
    get() = sum
    init {
        sum.value=startValue
    }

    fun gettotalsum(input:Int){
        sum.value=(sum.value)?.plus(input)
    }


}

