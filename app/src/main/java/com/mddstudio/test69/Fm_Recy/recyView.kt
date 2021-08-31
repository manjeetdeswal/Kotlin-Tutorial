package com.mddstudio.test69.Fm_Recy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mddstudio.test69.R

class recyView : AppCompatActivity() {
    private lateinit var recyclerView:RecyclerView
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recy_view)
        var listfruit= listOf(Fruit("Mango","1"),
            Fruit("Apple","2"),Fruit("Banana","3"),Fruit("Grapes","4"),Fruit("Gvaua","5"),Fruit("Orange","6"),
            Fruit("Pea","7"),Fruit("Chiki","8"), Fruit("Neem","9"))
        recyclerView=findViewById(R.id.recyclerView)
        myAdapter= MyAdapter(listfruit)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=myAdapter


    }
}