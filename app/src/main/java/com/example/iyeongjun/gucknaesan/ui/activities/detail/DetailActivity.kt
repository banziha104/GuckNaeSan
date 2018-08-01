package com.example.iyeongjun.gucknaesan.ui.activities.detail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.DetailAdapter
import com.example.iyeongjun.gucknaesan.const.DataDriver.mountToCal
import com.example.iyeongjun.gucknaesan.ex.plusAssign
import com.example.iyeongjun.gucknaesan.rx.AutoClearedDisposable
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import com.example.iyeongjun.gucknaesan.ui.activities.cal.CalActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity(), AnkoLogger {

    @Inject lateinit var viewModelFactory: DetailViewModelFactory
    lateinit var viewModel: DetailViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)
    lateinit var mMap : GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        viewModel = ViewModelProviders.of(this,viewModelFactory)[DetailViewModel::class.java]
        lifecycle += disposable
        lifecycle += viewDisposables
        bind()
    }

    fun bind(){
        viewDisposables += viewModel.driver.subscribe{ item ->
            txtDetailSubTitle.text = "   {fa-tag} 이름 : ${item.mtName}"
            txtDetailHeight.text = "   {fa-arrow-up} 높이 : ${item.height} "
            txtDetailAddress.text = "   {fa-map-marker} 위치 : ${item.address}"
            txtDetailDes.text = "${item.description}"
            txtDetailTitle.text = item.mtName
            if(!this.isFinishing){
                GlideApp
                        .with(this)
                        .load(item.imgUrl)
                        .into(imgDetail)
            }

            btnDetail.setOnClickListener {
                mountToCal.onNext(item)
                startActivity<CalActivity>()
            }
            val mapFragment =  supportFragmentManager.findFragmentById(R.id.mapDetail) as SupportMapFragment
            mapFragment.getMapAsync{
                val location = LatLng(item.lat,item.lon)
                mMap = it
                mMap.addMarker(MarkerOptions().position(location).title("산 위치"))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,11f))
            }
        }
        viewDisposables += viewModel.tourDriver
                .subscribe({
                    detailRecyclerView.apply {
                        adapter = DetailAdapter(it,this@DetailActivity)
                        layoutManager = LinearLayoutManager(this@DetailActivity)
                    }
                },{
                    it.printStackTrace()
                })
    }
}
