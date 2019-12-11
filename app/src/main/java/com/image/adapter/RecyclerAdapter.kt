package com.image.adapter

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.image.R
import com.image.bean.DataBean
import com.image.bean.JokeDataBean
import com.image.loge

class RecyclerAdapter(private val context:Context, private val itemList:List<DataBean>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        loge("------",itemList.size.toString())
        holder.text.text = itemList[position].content
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var text:TextView = itemView.findViewById(R.id.content)
    }

}