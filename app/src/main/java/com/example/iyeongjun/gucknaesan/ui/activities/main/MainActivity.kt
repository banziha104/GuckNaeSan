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
    val tabName = arrayOf("추천","명산","산악회")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    private fun bind(){
        mainViewpager.adapter = MainPagerAdapter(supportFragmentManager, listOf(RecoFragment(),MountFragment(),ClubFragment()))
//        for (i in 0..2) {
//            if (i == 0) tab.addTab(tab.newTab().setIcon(tabClicekdImages[i]).setText(tabNames[i]))
//            else tab.addTab(tab.newTab().setIcon(tabDefaultImages[i]).setText(tabNames[i]))
//        }
        for (i in 0..2){
            tab.addTab(tab.newTab().setText(tabName[i]))
        }
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
