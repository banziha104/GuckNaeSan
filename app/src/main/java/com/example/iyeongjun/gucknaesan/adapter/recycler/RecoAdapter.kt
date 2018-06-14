package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class RecoAdapter(val items : ArrayList<Item>) : RecyclerView.Adapter<RecoViewHolder>(), AnkoLogger{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_reco, parent, false)
        return RecoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecoViewHolder, position: Int) {
        holder.txtTitle.setText(items[position].mtName)
    }
}

class RecoViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val txtTitle = view.findViewById<TextView>(R.id.txtRecoTitle)
}