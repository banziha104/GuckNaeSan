package com.example.iyeongjun.gucknaesan.ui.activities.cal

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.CalAdapter
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ex.plusAssign
import com.example.iyeongjun.gucknaesan.ex.random
import com.example.iyeongjun.gucknaesan.rx.AutoClearedDisposable
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_cal.*
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject


class CalActivity : DaggerAppCompatActivity(), AnkoLogger {


    @Inject lateinit var calViewModelFactory: CalViewModelFactory
    @Inject lateinit var mountModel : MountModel
    lateinit var calViewModel: CalViewModel
    lateinit var adapter: CalAdapter
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal)
        calViewModel = ViewModelProviders.of(this, calViewModelFactory)[CalViewModel::class.java]
        lifecycle += disposable
        lifecycle += viewDisposables
        bind()
    }

    fun bind() {
        adapter = CalAdapter(calViewModel.item,this)

        calRecyclerView.apply {
            adapter = this@CalActivity.adapter
            layoutManager = LinearLayoutManager(this@CalActivity)
        }

        calendarView.apply {
            setOnDateChangeListener { view, year, month, dayOfMonth ->
                adapter = CalAdapter(calViewModel.item.random(),this@CalActivity)
                calRecyclerView.adapter = adapter
                calRecyclerView.adapter.notifyDataSetChanged()
            }
        }
        btnCal.setOnClickListener {
            Toast.makeText(this,"참여가 완료 되었습니다!",Toast.LENGTH_LONG)
        }
    }
}
