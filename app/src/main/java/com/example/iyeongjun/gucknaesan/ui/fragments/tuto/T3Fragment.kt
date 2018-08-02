package com.nicname.iyeongjun.nonglim.ui.fragments.tuto


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.const.DataDriver
import com.example.iyeongjun.gucknaesan.ui.activities.main.MainActivity
import com.yqritc.scalablevideoview.ScalableType
import kotlinx.android.synthetic.main.fragment_t1.*
import kotlinx.android.synthetic.main.fragment_t3.*
import kotlinx.android.synthetic.main.fragment_t3.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class T3Fragment : Fragment() {
    var flag = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t3, container, false)
    }

    override fun onResume() {
        super.onResume()
        placeholder3.visibility = View.VISIBLE
        videoView3.setRawData(R.raw.tutorial_3)
        videoView3.requestFocus()
        videoView3.setScalableType(ScalableType.CENTER_CROP)
        videoView3.isLooping = true
        videoView3.setOnClickListener {
            activity!!.startActivity<MainActivity>()
            activity!!.finish()
        }

        DataDriver.tutoDriver.filter { it == 3 }.subscribe ({
            if(!flag) {
                videoView3.prepareAsync {
                    it.start()
                    placeholder3.visibility = View.GONE
                    flag = !flag
                    val hd = Handler()
                    hd.postDelayed({
                        activity!!.toast("화면을 터치하면 다음으로 넘어갑니다")
                    }, 2000)
                }
            }
        },{it.printStackTrace()})
    }
}
