package com.example.iyeongjun.gucknaesan.ui.activities.cal

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.CalRecyclerAdapter
import com.example.iyeongjun.gucknaesan.ex.random
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_cal.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class CalActivity : DaggerAppCompatActivity(), AnkoLogger {

    @Inject
    lateinit var calViewModelFactory: CalViewModelFactory
    lateinit var calViewModel: CalViewModel
    lateinit var adapter: CalRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal)
        calViewModel = ViewModelProviders.of(this, calViewModelFactory)[CalViewModel::class.java]
        bind()
    }

    fun bind() {
        adapter = CalRecyclerAdapter(calViewModel.item,this)
        calRecyclerView.apply {
            adapter = this@CalActivity.adapter
            layoutManager = LinearLayoutManager(this@CalActivity)
        }
        calendarView.apply {
            setOnDateChangeListener { view, year, month, dayOfMonth ->
                adapter = CalRecyclerAdapter(calViewModel.item.random(),this@CalActivity)
                calRecyclerView.adapter = adapter
                calRecyclerView.adapter.notifyDataSetChanged()
            }
        }
    }
}
