package com.example.iyeongjun.gucknaesan.ui.activities.main

import android.os.Bundle
import android.support.design.widget.TabLayout
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.MainPagerAdapter
import com.example.iyeongjun.gucknaesan.ui.fragments.club.ClubFragment
import com.example.iyeongjun.gucknaesan.ui.fragments.mount.MountFragment
import com.example.iyeongjun.gucknaesan.ui.fragments.reco.RecoFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), AnkoLogger {
    @Inject lateinit var viewModel: MainViewModelFactory
    val tabNames = arrayOf("추천","명산","산악회")
    val tabImages = arrayOf(R.drawable.item_reco,R.drawable.item_mount,R.drawable.item_club)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    private fun bind(){
        mainViewpager.adapter = MainPagerAdapter(supportFragmentManager, listOf(RecoFragment(),MountFragment(),ClubFragment()))
        for (i in 0..2) tab.addTab(tab.newTab().setIcon(tabImages[i]).setText(tabNames[i]))

        mainViewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        tab.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(mainViewpager))
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tabs: TabLayout.Tab) {

            }
            override fun onTabUnselected(tabs: TabLayout.Tab) {

            }
            override fun onTabReselected(tabs: TabLayout.Tab) {

            }
        })
    }
}
