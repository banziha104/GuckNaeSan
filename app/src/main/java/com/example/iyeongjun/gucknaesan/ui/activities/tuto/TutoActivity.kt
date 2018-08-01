package com.example.iyeongjun.gucknaesan.ui.activities.tuto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.view.ViewPager
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.MainPagerAdapter
import com.example.iyeongjun.gucknaesan.const.DataDriver.tutoDriver
import com.example.iyeongjun.gucknaesan.const.mediaURL
import com.example.iyeongjun.gucknaesan.ui.activities.main.MainActivity
import com.nicname.iyeongjun.nonglim.ui.fragments.tuto.T1Fragment
import com.nicname.iyeongjun.nonglim.ui.fragments.tuto.T2Fragment
import com.nicname.iyeongjun.nonglim.ui.fragments.tuto.T3Fragment
import com.yqritc.scalablevideoview.ScalableType
import kotlinx.android.synthetic.main.activity_tuto.*
import kotlinx.android.synthetic.main.fragment_t1.*
import kotlinx.android.synthetic.main.fragment_t2.*
import kotlinx.android.synthetic.main.fragment_t3.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class TutoActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuto)
        mediaURL = "android.resource://" + packageName + "/"
        bind()
    }
    fun bind(){
        tutoViewPager.adapter = MainPagerAdapter(supportFragmentManager,listOf(T1Fragment(), T2Fragment(), T3Fragment()))
        tutoViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> tutoDriver.onNext(1)
                    1 -> tutoDriver.onNext(2)
                    2 -> tutoDriver.onNext(3)
                }
            }
        })
        pageindicator.initViewPager(tutoViewPager)
        tutoDriver.onNext(1)
    }
}
