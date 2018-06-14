package com.example.iyeongjun.gucknaesan.ui.fragments.club


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import dagger.android.support.DaggerFragment
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class ClubFragment : DaggerFragment(),AnkoLogger {
    @Inject lateinit var model : MountModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        info(model)
        return inflater.inflate(R.layout.fragment_club, container, false)
    }
}
