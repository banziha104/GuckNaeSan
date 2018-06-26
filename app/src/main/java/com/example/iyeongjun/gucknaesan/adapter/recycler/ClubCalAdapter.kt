package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ui.GlideApp

class ClubCalAdapter(val data : List<Item>, val context : Context) : RecyclerView.Adapter<ClubCalAdapter.ClubCarViewHoler>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubCarViewHoler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cal_club, parent, false)
        return ClubCarViewHoler(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ClubCarViewHoler, position: Int) {
        Log.d("temp",data[position].toString())
        holder.apply {
            data[position].let {
                title.text = it.mtName
                location.text = it.address
                des.text = it.description
                GlideApp
                        .with(context)
                        .load(it.imgUrl)
                        .into(imageView)
            }
        }
    }

    inner class ClubCarViewHoler(view : View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.txtCarClubTitle)
        val location = view.findViewById<TextView>(R.id.txtCarClubLocation)
        val des = view.findViewById<TextView>(R.id.txtCarClubDes)
        val imageView = view.findViewById<ImageView>(R.id.imgCarClub)
    }
}