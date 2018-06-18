package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.ex.getLimitedString
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import com.example.iyeongjun.gucknaesan.ui.activities.detail.DetailActivity
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.subjects.BehaviorSubject
import org.jetbrains.anko.startActivity

class MountAdapter(val items : List<Item>, val context : Context,val sendDriver : BehaviorSubject<Item>
                   ) : RecyclerView.Adapter<MountAdapter.MountViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MountViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mount, parent, false)
        return MountViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MountViewHolder, position: Int) {
        holder.apply {
            items[position].let {
                item = it
                txtTitle.setText(it.mtName)
                txtDes.setText(it.description.getLimitedString(180))
                txtHeight.setText("${it.height}m")
                GlideApp
                        .with(context)
                        .load(items[position].imgUrl)
                        .into(imgMount)
            }
        }
    }
    inner class MountViewHolder (view: View) : RecyclerView.ViewHolder(view){
        var item : Item? = null
        val txtTitle = view.findViewById<TextView>(R.id.txtMountTitle)
        val txtDes = view.findViewById<TextView>(R.id.txtMountDes)
        val txtHeight= view.findViewById<TextView>(R.id.txtMountHeight)
        val imgMount = view.findViewById<ImageView>(R.id.imgMount)
        val container = view.findViewById<ConstraintLayout>(R.id.mountContainer)
        init { bind() }

        fun bind(){
            container.setOnClickListener {
                sendDriver.onNext(item!!)
                context.startActivity<DetailActivity>()
            }
        }
    }
}


