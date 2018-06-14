package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.mount.Item

class MountAdapter(val items : List<Item>) : RecyclerView.Adapter<MountViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MountViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mount, parent, false)
        return MountViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MountViewHolder, position: Int) {
        holder.txtTitle.setText(items[position].mtName)
        holder.txtDes.setText(items[position].description)
        holder.txtHeight.setText("${items[position].height}m")
    }
}


class MountViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val txtTitle = view.findViewById<TextView>(R.id.txtMountTitle)
    val txtDes = view.findViewById<TextView>(R.id.txtMountDes)
    val txtHeight= view.findViewById<TextView>(R.id.txtMountHeight)
}