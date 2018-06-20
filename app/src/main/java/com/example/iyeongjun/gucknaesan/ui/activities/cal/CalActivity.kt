package com.example.iyeongjun.gucknaesan.ui.activities.cal

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.CalRecyclerAdapter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_cal.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class CalActivity : DaggerAppCompatActivity(), AnkoLogger {

    @Inject lateinit var  calViewModelFactory: CalViewModelFactory
    lateinit var calViewModel: CalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal)
        calViewModel = ViewModelProviders.of(this,calViewModelFactory)[CalViewModel::class.java]
        bind()
    }
    fun bind(){
        calRecyclerView.apply {
            adapter = CalRecyclerAdapter(calViewModel.clubModel.items)
            layoutManager = LinearLayoutManager(this@CalActivity)
        }
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            info("$view / $year / $month / $dayOfMonth")
        }
    }
}
