package com.example.iyeongjun.gucknaesan.ui.activities.cal

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.CalAdapter
import com.example.iyeongjun.gucknaesan.api.model.club.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ex.plusAssign
import com.example.iyeongjun.gucknaesan.ex.random
import com.example.iyeongjun.gucknaesan.rx.AutoClearedDisposable
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_cal.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import javax.inject.Inject


class CalActivity : DaggerAppCompatActivity(), AnkoLogger {


    @Inject lateinit var calViewModelFactory: CalViewModelFactory
    lateinit var calViewModel: CalViewModel
    lateinit var adapter: CalAdapter
    var list : ArrayList<Boolean> = arrayListOf()
    var day : Int? =null
    var month : Int? = null
    var item : Item? = null
    val driver : PublishSubject<Item> = PublishSubject.create()
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal)
        calViewModel = ViewModelProviders.of(this, calViewModelFactory)[CalViewModel::class.java]
        lifecycle += disposable
        lifecycle += viewDisposables
        for(i in 0..calViewModel.item.random().size) list.add(false)
        bind()
    }

    fun bind() {
        adapter = CalAdapter(calViewModel.item.random(),this,driver)
        calRecyclerView.apply {
            adapter = this@CalActivity.adapter
            layoutManager = LinearLayoutManager(this@CalActivity)
        }

        calendarView.apply {
            setOnDateChangeListener { view, year, month, dayOfMonth ->
                this@CalActivity.day = dayOfMonth
                this@CalActivity.month = month
                adapter = CalAdapter(calViewModel.item.random(),this@CalActivity,driver)
                calRecyclerView.adapter = adapter
                calRecyclerView.adapter.notifyDataSetChanged()
            }
        }
        btnCal.setOnClickListener {
            if(item != null && day != null) toast("${month}월 ${day}일에 ${item?.clubName}에 참가신청 되었습니다").show()
            else toast("날짜와 산악회를 선택해주세요").show()
        }
        driver.subscribe { item = it }
    }
}
