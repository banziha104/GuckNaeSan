package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.tour.TourModel
import com.example.iyeongjun.gucknaesan.ex.convertType
import com.example.iyeongjun.gucknaesan.ex.getLimitedString
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import com.example.iyeongjun.gucknaesan.ui.dialogs.ConfirmDialog
import com.example.iyeongjun.gucknaesan.ui.dialogs.TourDialog
import org.jetbrains.anko.toast


class DetailAdapter(val model : TourModel,
                    val context : AppCompatActivity) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>(){
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
                temp = it
                title.text = "이름 : ${it.title}"
                location.text = "주소 : ${it.addr1}"
                type.text = "분류 : ${it.contenttypeid.convertType()}"
                if(it.firstimage != null && it.firstimage != ""){
                    GlideApp
                            .with(context)
                            .load(it.firstimage)
                            .circleCrop()
                            .into(img)
                }else{
                    GlideApp
                            .with(context)
                            .load(R.drawable.default_tour_img)
                            .circleCrop()
                            .into(img)
                }
            }
        }
    }
    inner class DetailViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.txtDeReTitle)
        val location = view.findViewById<TextView>(R.id.txtDeReLocation)
        val type = view.findViewById<TextView>(R.id.txtDeReType)
        val img = view.findViewById<ImageView>(R.id.imgDeRe)
        val container = view.findViewById<ConstraintLayout>(R.id.deReContainer)
        var temp : TourModel.BodyBean.ItemBean? = null
        init {
            container.setOnClickListener {
                val dialog = TourDialog(context,temp!!)
                dialog!!.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                dialog!!.show()
            }
        }
    }
}