package com.mddstudio.test69.Coroutine

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.*

class MyVIewMOdel : ViewModel() {
    private var userre = UserRapo()
    var users= liveData(Dispatchers.IO) {
        val result=userre.getusers()
        emit(result)
    }
    /*var users:MutableLiveData<List<User>> =MutableLiveData()

    fun getuser() {
        viewModelScope.launch {
            var result: List<User>? = null
            withContext(Dispatchers.IO){
                result=userre.getusers()
            }
            users.value=result!!
        }

    }*/


}