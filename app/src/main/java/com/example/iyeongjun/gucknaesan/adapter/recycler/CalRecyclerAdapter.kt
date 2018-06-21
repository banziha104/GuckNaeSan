package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.club.Item

class CalRecyclerAdapter(val data : List<Item>) : RecyclerView.Adapter<CalRecyclerAdapter.CalViewHolder>(){
   init {
       Log.d("a","$data")
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cal, parent, false)
        return CalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CalViewHolder, position: Int) {
        holder.apply {
            data[position].let {
                txtClub.text = it.clubName
            }
        }
    }

    inner class CalViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtClub = view.findViewById<TextView>(R.id.txtCalTitle)
    }
}
