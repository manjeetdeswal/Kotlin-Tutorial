package com.mddstudio.test69.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mddstudio.test69.R
import com.mddstudio.test69.databinding.ActivityRoomDbBinding


class roomDb : AppCompatActivity() {
    private lateinit var binding: ActivityRoomDbBinding
    private lateinit var subViewModel: SubViewModel
    private lateinit var recAdpater: RecAdpater
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_db)
        val dao = SubData.getINstance(applicationContext).subDao
        val rapo = Rapos(dao)
        val factory = SubFactory(rapo)
        subViewModel = ViewModelProvider(this, factory).get(SubViewModel::class.java)
        binding.myview = subViewModel
        binding.lifecycleOwner = this
        intec()

        subViewModel.messs.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Snackbar.make(binding.emailText, it.toString(), Snackbar.LENGTH_LONG).show()
            }
        })
    }

    private fun listItemClicked(subscriber: Subscriber) {
        Toast.makeText(this, "selected name is ${subscriber.name}", Toast.LENGTH_LONG).show()
        subViewModel.intupdaaedelete(subscriber)
    }


    private fun displaylist() {
        subViewModel.subscriber.observe(this, Observer {
            Log.i("myaa", it.toString())
            recAdpater.setlis(it)
            recAdpater.notifyDataSetChanged()
        })

    }

    private fun intec() {
        recAdpater = RecAdpater({ itemseliec: Subscriber -> listItemClicked(itemseliec) })
        binding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.subscriberRecyclerView.adapter=recAdpater
        displaylist()

    }
}