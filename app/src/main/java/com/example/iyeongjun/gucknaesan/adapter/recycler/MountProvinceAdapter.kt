package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R
import io.reactivex.subjects.BehaviorSubject

class MountProvinceAdapter(val data : List<String>, val clickDriver : BehaviorSubject<String>) : RecyclerView.Adapter<MountProvinceAdapter.ProvinceViewHolder>(){
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

    inner class ProvinceViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val txtTitle = view.findViewById<TextView>(R.id.txtProvinceTitle)
        val container = view.findViewById<ConstraintLayout>(R.id.provinceContainer)
        init {
            container.setOnClickListener {
                clickDriver.onNext(txtTitle.text.toString())
            }
        }
    }
}