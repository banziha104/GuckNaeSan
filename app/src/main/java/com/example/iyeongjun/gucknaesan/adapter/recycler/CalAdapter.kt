package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.club.Item
import com.example.iyeongjun.gucknaesan.ui.GlideApp

class CalAdapter(val data : List<Item>, val context: Activity) : RecyclerView.Adapter<CalAdapter.CalViewHolder>(){
   init {
       Log.d("a","$data")
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_club, parent, false)
        return CalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CalViewHolder, position: Int) {
        holder.apply {
            data[position].let {
                txtTitle.text = it.clubName
                txtLocation.text = it.adress
                txtDes.text = it.cintroduce
                GlideApp
                        .with(context)
                        .load(it.imgUrl)
                        .into(imgClub)
            }
        }
    }

    inner class CalViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtTitle = view.findViewById<TextView>(R.id.txtClubTitle)
        val txtDes = view.findViewById<TextView>(R.id.txtClubDes)
        val txtLocation = view.findViewById<TextView>(R.id.txtClubLocation)
        val imgClub = view.findViewById<ImageView>(R.id.imgClub)
    }
}
