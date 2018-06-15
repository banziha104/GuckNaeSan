package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.w3c.dom.Text

class RecoAdapter(val items : ArrayList<Item>,val context : Context) : RecyclerView.Adapter<RecoViewHolder>(), AnkoLogger{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_reco, parent, false)
        return RecoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecoViewHolder, position: Int) {
        holder.txtTitle.setText(items[position].mtName)
        holder.txtHeight.setText("${items[position].height}m")
        GlideApp.with(context)
                .load(items[position].imgUrl)
                .into(holder.imgView)
    }
}

class RecoViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val txtTitle = view.findViewById<TextView>(R.id.txtRecoTitle)
    val txtHeight = view.findViewById<TextView>(R.id.txtRecoHeight)
    val imgView = view.findViewById<ImageView>(R.id.imgReco)
}