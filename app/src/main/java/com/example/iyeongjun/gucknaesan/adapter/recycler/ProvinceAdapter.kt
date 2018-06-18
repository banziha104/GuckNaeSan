package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R

class ProvinceAdapter(val data : List<String>) : RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_province, parent, false)
        return ProvinceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.apply {
            data[position].let {
                txtTitle.text = it
            }
        }
    }

    class ProvinceViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtTitle = view.findViewById<TextView>(R.id.txtProvinceTitle)

    }
}