package com.mddstudio.test69.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainModel : ViewModel() {
     var count =MutableLiveData<Int>()
    val coutnData:LiveData<Int>
        get() = count
init {
    count.value=0
}
    fun upadatcount(){
         count.value=count.value?.plus(1)
    }

}