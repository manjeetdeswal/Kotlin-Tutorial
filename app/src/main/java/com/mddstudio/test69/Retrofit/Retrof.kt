package com.mddstudio.test69.Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData

import com.mddstudio.test69.R
import retrofit2.Response


class Retrof : AppCompatActivity() {
    private lateinit var text_view:TextView
    private lateinit var retroservice:AlbService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        text_view=findViewById(R.id.text_view)
         retroservice=RetroInstance.getRetrofitInstance().create(AlbService::class.java)
        getrequestpath()
        getrequestquery()
        uploABLBUM()










    }
    private fun uploABLBUM(){
        val album=AlbumsItem(0,"My title",3)
        val postresponse :LiveData<Response<AlbumsItem>>  = liveData {
            val respnd :Response<AlbumsItem> =retroservice.postrtalb(album)
            emit(respnd)
        }
        postresponse.observe(this, Observer {
            val receivedalb=it.body()
            val result =" "+"Album Title : ${receivedalb?.title}"+"\n"+
                    " "+"Album id : ${receivedalb?.id}"+"\n"+
                    " "+"User id : ${receivedalb?.userId}"+"\n\n\n"
            text_view.append(result)
        })

    }
    private fun getrequestpath(){
        val pathresposn = liveData {
            val response1  =retroservice.getrtalb(2)
            emit(response1)
        }
        pathresposn.observe(this, Observer {
            val title=it.body()?.title
            Toast.makeText(this,title.toString(),Toast.LENGTH_LONG).show()
        })
    }
    private fun getrequestquery(){
        val responeslive:LiveData<Response<Albums>> = liveData {
            val response=retroservice.getalbums()
            emit(response)
        }
        responeslive.observe(this, Observer {
            val ablum=it.body()?.listIterator()
            if (ablum!=null){
                while (ablum.hasNext()){
                    val albumsItem:AlbumsItem=ablum.next()
                    Log.i("fdnfc",albumsItem.title)
                    val result =" "+"Album Title : ${albumsItem.title}"+"\n"+
                            " "+"Album id : ${albumsItem.id}"+"\n"+
                            " "+"User id : ${albumsItem.userId}"+"\n\n\n"
                    text_view.append(result)
                }
            }
        })
    }
}