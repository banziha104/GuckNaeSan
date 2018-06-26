package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.club.Item
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import com.example.iyeongjun.gucknaesan.ui.activities.club.ClubDetailActivity
import com.google.android.gms.maps.SupportMapFragment
import io.reactivex.subjects.BehaviorSubject
import org.jetbrains.anko.startActivity


class ClubAdapter(val data : List<Item>,val context: Context, val fragment: Fragment ,val driver : BehaviorSubject<Item>) : RecyclerView.Adapter<ClubAdapter.ClubViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_club, parent, false)
        return ClubViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.apply {
            data[position].let {
                item = it
                txtTitle.text = it.clubName
                txtDes.text = it.cintroduce
                txtLocation.text = ""
                GlideApp.with(fragment)
                        .load(it.imgUrl)
                        .into(imgClub)
            }
        }
    }

    inner class ClubViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var item : Item? = null
        val txtTitle = view.findViewById<TextView>(R.id.txtClubTitle)
        val txtDes = view.findViewById<TextView>(R.id.txtClubDes)
        val txtLocation = view.findViewById<TextView>(R.id.txtClubLocation)
        val imgClub = view.findViewById<ImageView>(R.id.imgClub)
        val container = view.findViewById<ConstraintLayout>(R.id.clubContainer)

        init{bind()}

        fun bind(){
            container.setOnClickListener {
                driver.onNext(item!!)
                context.startActivity<ClubDetailActivity>()
            }
        }
    }
}