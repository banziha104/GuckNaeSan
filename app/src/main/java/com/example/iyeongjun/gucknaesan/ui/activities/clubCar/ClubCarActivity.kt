package com.example.iyeongjun.gucknaesan.ui.activities.clubCar

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.CalAdapter
import com.example.iyeongjun.gucknaesan.adapter.recycler.ClubCalAdapter
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.ex.plusAssign
import com.example.iyeongjun.gucknaesan.ex.random
import com.example.iyeongjun.gucknaesan.ex.random2
import com.example.iyeongjun.gucknaesan.rx.AutoClearedDisposable
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_cal.*
import kotlinx.android.synthetic.main.activity_club_car.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import java.util.*
import javax.inject.Inject

class ClubCarActivity : DaggerAppCompatActivity() , AnkoLogger{
    @Inject lateinit var clubCarViewModelFactory: ClubCarViewModelFactory
    lateinit var viewModel: ClubCarViewModel
    lateinit var adapter : ClubCalAdapter
    var temp : Item? = null
    var day : Int? = null
    var month : Int? =null
    val driver : PublishSubject<Item> = PublishSubject.create()
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club_car)

        viewModel = ViewModelProviders.of(this,clubCarViewModelFactory)[ClubCarViewModel::class.java]
        lifecycle += disposable
        lifecycle += viewDisposables
        bind()
    }
    fun bind(){
        var adapter = ClubCalAdapter(viewModel.model.random2(),this@ClubCarActivity,driver)
        clubCarRecyclerview.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@ClubCarActivity)
        }
        clubCalendarView.apply {
            setOnDateChangeListener { view, year, month, dayOfMonth ->
                this@ClubCarActivity.day = dayOfMonth
                this@ClubCarActivity.month = month
                adapter = ClubCalAdapter(viewModel.model.random2(),this@ClubCarActivity,driver)
                clubCarRecyclerview.adapter = adapter
                clubCarRecyclerview.adapter.notifyDataSetChanged()
            }
        }
        driver.subscribe {
            temp = it
        }
        btnClubCal.setOnClickListener { view ->
            if(temp != null && day != null) {
                toast("${(month!!+1)}월 ${day}일에 ${temp?.mtName}에 예약되었습니다.")
            }else{
                toast("날짜와 산을 선택해주세요")
            }
        }
    }
}
