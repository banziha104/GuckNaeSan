package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.tour.TourModel
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import org.jetbrains.anko.toast


class DetailAdapter(val model : TourModel,
                    val context : Context) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>(){
    val item = model.body.items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_detail,parent,false)
        return DetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.apply {
            item[position].let {
                title.text = it.title
                location.text = it.addr1
                tell.text = it.tel
                if(it.firstimage != null && it.firstimage != ""){
                    GlideApp
                            .with(context)
                            .load(it.firstimage)
                            .into(img)
                }
            }
        }
    }
    inner class DetailViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.txtDeReTitle)
        val location = view.findViewById<TextView>(R.id.txtDeReLocation)
        val tell = view.findViewById<TextView>(R.id.txtDeReTel)
        val img = view.findViewById<ImageView>(R.id.imgDeRe)
        val container = view.findViewById<ConstraintLayout>(R.id.deReContainer)
        init {
            container.setOnClickListener {
                context.toast("클릭")
            }
        }
    }
}