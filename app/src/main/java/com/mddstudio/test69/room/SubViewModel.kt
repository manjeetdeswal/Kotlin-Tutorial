package com.mddstudio.test69.room

import android.util.Patterns
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubViewModel(private var rapos: Rapos) : ViewModel(),Observable {

    private var isupdateordelete=false
    private lateinit var subupdatedelete:Subscriber
    private val stautsmess= MutableLiveData<Event<String>>()

    val messs:LiveData<Event<String>>
    get() = stautsmess

    val subscriber=rapos.subscriber

    @Bindable
    val inputname = MutableLiveData<String?>()

    @Bindable
    var inputemail = MutableLiveData<String?>()

    @Bindable
    val saveUpdatae = MutableLiveData<String>()

    @Bindable
    val clersDelete = MutableLiveData<String>()

    init {
        saveUpdatae.value = "Save"
        clersDelete.value = "Clear All"
    }

     fun saveUpdate() {
         if (inputname==null || inputemail==null){
             stautsmess.value= Event("Error  Succesfully")
         }
        else if (!Patterns.EMAIL_ADDRESS.matcher(inputemail.value).matches()){
             stautsmess.value= Event("Error  Succesfully")
         }
       else  if (isupdateordelete){
             subupdatedelete.name=inputname.value!!
             subupdatedelete.email=inputemail.value!!
             update(subupdatedelete)
         }
         else {
             val name: String = inputname.value!!
             val email: String = inputemail.value!!
             inser(Subscriber(0, name, email))
             inputemail.value = null
             inputname.value = null
         }
    }

    fun del() {
        if (isupdateordelete){
            delete(subupdatedelete)
        }else {
            deletatall()
        }
    }

     fun inser(subscriber: Subscriber) {
        viewModelScope.launch{
         val newrow:Long=  rapos.insert(subscriber)
            if (newrow>-1){
                stautsmess.value= Event("Data Added Succesfully  $newrow")
            }else{
                stautsmess.value= Event("Error  Succesfully")
            }

        }

    }
     fun delete(subscriber: Subscriber) {
        viewModelScope.launch{
         val nofreg=   rapos.delete(subscriber)
            if (nofreg>-1){
                stautsmess.value= Event("Data Added Succesfully  $nofreg")
            }else{
                stautsmess.value= Event("Error  Succesfully")
            }
        }
         inputname.value=null
         inputemail.value=null
         isupdateordelete=false
         subupdatedelete=subscriber
         saveUpdatae.value="Save"
         clersDelete.value="Clear List"
    }
     fun update(subscriber: Subscriber) {
        viewModelScope.launch{

         val norow=    rapos.update(subscriber)
            if (norow>-1){
                stautsmess.value= Event("Data Added Succesfully  $norow")
            }else{
                stautsmess.value= Event("Error  Succesfully")
            }

        }

         inputname.value=null
         inputemail.value=null
         isupdateordelete=false
         subupdatedelete=subscriber
         saveUpdatae.value="Save"
         clersDelete.value="Clear List"
    }


     fun deletatall() {
         CoroutineScope(Dispatchers.IO).launch{
           val nofre=  rapos.deleteall()
             if (nofre>-1){
                 stautsmess.value= Event("Data Added Succesfully  $nofre")
             }else{
                 stautsmess.value= Event("Error  Succesfully")
             }

         }
    }

    fun intupdaaedelete(subscriber: Subscriber) {
        inputname.value=subscriber.name
        inputemail.value=subscriber.email
        isupdateordelete=true
        subupdatedelete=subscriber
        saveUpdatae.value="Update"
        clersDelete.value="Delete"

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}