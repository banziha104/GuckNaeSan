package com.example.iyeongjun.gucknaesan.ui.fragments.club


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.iyeongjun.gucknaesan.R
import dagger.android.support.DaggerFragment

class ClubFragment : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_club, container, false)
    }
}
