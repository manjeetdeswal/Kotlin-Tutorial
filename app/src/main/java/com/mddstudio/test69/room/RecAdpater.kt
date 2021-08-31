package com.mddstudio.test69.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mddstudio.test69.R
import com.mddstudio.test69.databinding.Listitem1Binding


class RecAdpater(private val clickListener: (Subscriber)->Unit) : RecyclerView.Adapter<myviewhold>() {

    private val subscriberlis= ArrayList<Subscriber>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewhold {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: Listitem1Binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.listitem1, parent, false)
        return myviewhold(binding)
    }

    override fun onBindViewHolder(holder: myviewhold, position: Int) {
        holder.bind(subscriberlis[position],clickListener)
    }

    override fun getItemCount(): Int {
        return subscriberlis.size
    }
    fun setlis(subscriber: List<Subscriber>){
        subscriberlis.clear()
        subscriberlis.addAll(subscriber)
    }
}

class myviewhold(val binding: Listitem1Binding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(subscriber: Subscriber,clickListener: (Subscriber)->Unit) {
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email
        binding.listItemLayout.setOnClickListener{
            clickListener(subscriber)
        }
    }
}