package com.example.iyeongjun.gucknaesan.ui.fragments.mount


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import dagger.android.support.DaggerFragment
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject


class MountFragment : DaggerFragment(),AnkoLogger {
    @Inject lateinit var mountViewModelFactory: MountViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_mount, container, false)
    }
}
