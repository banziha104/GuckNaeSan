package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import io.reactivex.subjects.PublishSubject

class ClubCalAdapter(val data : List<Item>, val context : Context,val  driver : PublishSubject<Item>) : RecyclerView.Adapter<ClubCalAdapter.ClubCarViewHoler>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubCarViewHoler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cal_club, parent, false)
        return ClubCarViewHoler(view)
    }

    override fun getItemCount(): Int {
        Log.d("temp","${data.size}")
        return data.size
    }

    override fun onBindViewHolder(holder: ClubCarViewHoler, position: Int) {
        Log.d("temp",data[position].toString())
        holder.apply {
            data[position].let {
                item = it
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
        var item : Item? = null
        val title = view.findViewById<TextView>(R.id.txtCarClubTitle)
        val location = view.findViewById<TextView>(R.id.txtCarClubLocation)
        val des = view.findViewById<TextView>(R.id.txtCarClubDes)
        val imageView = view.findViewById<ImageView>(R.id.imgCarClub)
        val container = view.findViewById<ConstraintLayout>(R.id.carClubContainer)
        init {
            bind()
        }
        fun bind(){
            container.setOnClickListener {
                driver.onNext(item!!)
                Toast.makeText(context,"${item?.mtName}이 선택되었습니다",Toast.LENGTH_SHORT).show()
            }
        }
    }
}