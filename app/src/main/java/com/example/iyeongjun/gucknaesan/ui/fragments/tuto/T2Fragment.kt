package com.nicname.iyeongjun.nonglim.ui.fragments.tuto

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.const.DataDriver
import com.yqritc.scalablevideoview.ScalableType
import kotlinx.android.synthetic.main.fragment_t1.*
import kotlinx.android.synthetic.main.fragment_t2.*
import kotlinx.android.synthetic.main.fragment_t3.*

class T2Fragment : Fragment() {
    var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t2, container, false)
    }

    override fun onResume() {
        super.onResume()
        placeholder2.visibility = View.VISIBLE
        videoView2.setRawData(R.raw.tutorial_2)
        videoView2.isLooping = true
        videoView2.requestFocus()
        videoView2.setScalableType(ScalableType.CENTER_CROP)
        DataDriver.tutoDriver.filter { it == 2 }.subscribe ({
            if(!flag) {
                videoView2.prepareAsync {
                    it.start()
                    placeholder2.visibility = View.INVISIBLE
                    flag = !flag
                }
            }
        },{it.printStackTrace()})

    }
}
