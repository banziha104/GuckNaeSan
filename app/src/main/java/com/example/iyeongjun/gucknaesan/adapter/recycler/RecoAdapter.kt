package com.example.iyeongjun.gucknaesan.adapter.recycler

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.arch.TourApi
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.tour.TourModel
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import com.example.iyeongjun.gucknaesan.ui.activities.detail.DetailActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import java.net.URL

class RecoAdapter(val items: ArrayList<Item>,
                  val context: Context,
                  val fragment: Fragment,
                  val sendDriver: BehaviorSubject<Item>,
                  val tourDriver: BehaviorSubject<TourModel>,
                  val tourApi: TourApi,
                  val progressBar: ProgressBar) : RecyclerView.Adapter<RecoAdapter.RecoViewHolder>(), AnkoLogger {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_reco, parent, false)
        return RecoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecoViewHolder, position: Int) {
        holder.apply {
            items[position].let {
                item = it
                txtTitle.text = it.mtName
                txtHeight.text = "${it.height}m"
                txtAddress.text = it.address
                GlideApp.with(fragment)
                        .load(URL(it.imgUrl))
                        .into(imgView)
            }
        }
    }

    inner class RecoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var item: Item? = null
        val txtTitle = view.findViewById<TextView>(R.id.txtRecoTitle)
        val txtHeight = view.findViewById<TextView>(R.id.txtRecoHeight)
        val txtAddress = view.findViewById<TextView>(R.id.txtRecoAddress)
        val imgView = view.findViewById<ImageView>(R.id.imgReco)

        init {
            bind()
        }

        fun bind() {
            imgView.setOnClickListener {
                sendDriver.onNext(item!!)
                tourApi.getTourData(lon = item?.lon!!, lat = item?.lat!!)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnComplete {
                            progressBar.visibility = View.INVISIBLE
                            context.startActivity<DetailActivity>()
                        }
                        .doOnSubscribe { progressBar.visibility = View.VISIBLE }
                        .observeOn(Schedulers.io())
                        .subscribe({
                            tourDriver.onNext(it)
                        }, {
                            it.printStackTrace()
                        })
            }
        }
    }
}

