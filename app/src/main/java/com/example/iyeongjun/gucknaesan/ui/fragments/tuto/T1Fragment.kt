package com.nicname.iyeongjun.nonglim.ui.fragments.tuto

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.R.id.videoView
import com.example.iyeongjun.gucknaesan.const.DataDriver.tutoDriver
import com.example.iyeongjun.gucknaesan.const.mediaURL
import com.yqritc.scalablevideoview.ScalableType
import kotlinx.android.synthetic.main.fragment_t1.*
import kotlinx.android.synthetic.main.fragment_t3.*

class T1Fragment : Fragment() {
    var flag = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t1, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        Log.d("dd","${Uri.parse(mediaURL + R.raw.tutorial_1)}")
//        videoView.setVideoURI(Uri.parse(mediaURL + R.raw.tutorial_1))
        placeholder1.visibility = View.VISIBLE
        videoView.setRawData(R.raw.tutorial_1)
        videoView.requestFocus()
        videoView.isLooping = true
        videoView.setScalableType(ScalableType.CENTER_CROP)
        tutoDriver.filter { it == 1 }.subscribe({
            if(!flag) {
                videoView.prepareAsync {
                    it.start()
                    placeholder1.visibility = View.GONE
                }
                flag = !flag
            }
        },{it.printStackTrace()})


//        videoView.setRawData(R.raw.tutorial_1)
//        videoView.setScalableType(ScalableType.CENTER_CROP)
//        videoView.prepareAsync()
//        videoView.
//        videoView.prepare(object : MediaPlayer.OnPreparedListener {
//            override fun onPrepared(mp: MediaPlayer?) {
//                mp?.start()
//            }
//        })
    }
}
