package com.example.iyeongjun.gucknaesan.ui.activities.detail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.iyeongjun.gucknaesan.R
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

    lateinit var mMap : GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        viewModel = ViewModelProviders.of(this,viewModelFactory)[DetailViewModel::class.java]
        bind()
    }
    fun bind(){
        viewModel.driver.subscribe{ item ->
            txtDetailDes.text = "{fa-heart-o} ${item.description}"
            txtDetailTitle.text = item.mtName
            if(!this.isFinishing){
                GlideApp.with(this)
                        .load(item.imgUrl)
                        .into(imgDetail)
            }

            btnDetail.setOnClickListener {
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
    }
}
