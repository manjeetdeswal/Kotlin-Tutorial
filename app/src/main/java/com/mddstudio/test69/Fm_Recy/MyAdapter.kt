package com.mddstudio.test69.Fm_Recy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.mddstudio.test69.R

class MyAdapter(var listfruit:List<Fruit>) : RecyclerView.Adapter<MyAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val listitem =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyHolder(listitem)

    }



    override fun onBindViewHolder(holder: MyHolder, position: Int) {
       holder.bind(listfruit [position])

    }

    override fun getItemCount(): Int {
        return listfruit.size
    }
    class MyHolder(val view: View) : RecyclerView.ViewHolder(view) {


        var editText: TextView = view.findViewById(R.id.textView1)
        var imageview: ImageView = view.findViewById(R.id.imageView)

        fun bind(fruit: Fruit){
            editText.text=fruit.name
            imageview.setImageResource(R.mipmap.ic_launcher)
            editText.setOnClickListener {
                Toast.makeText(view.context,fruit.image,Toast.LENGTH_LONG).show()
            }
        }


    }



}


