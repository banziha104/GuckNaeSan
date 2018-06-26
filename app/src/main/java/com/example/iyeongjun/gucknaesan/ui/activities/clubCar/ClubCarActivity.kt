package com.example.iyeongjun.gucknaesan.ui.activities.clubCar

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.adapter.recycler.CalAdapter
import com.example.iyeongjun.gucknaesan.adapter.recycler.ClubCalAdapter
import com.example.iyeongjun.gucknaesan.ex.plusAssign
import com.example.iyeongjun.gucknaesan.ex.random
import com.example.iyeongjun.gucknaesan.rx.AutoClearedDisposable
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_cal.*
import kotlinx.android.synthetic.main.activity_club_car.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class ClubCarActivity : DaggerAppCompatActivity() , AnkoLogger{
    @Inject lateinit var clubCarViewModelFactory: ClubCarViewModelFactory
    lateinit var viewModel: ClubCarViewModel
    lateinit var adapter : ClubCalAdapter

    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club_car)

        viewModel = ViewModelProviders.of(this,clubCarViewModelFactory)[ClubCarViewModel::class.java]
        lifecycle += disposable
        lifecycle += viewDisposables
    }
    fun bind(){
        var adapter = ClubCalAdapter(viewModel.model.random(),this@ClubCarActivity)
        clubCarRecyclerview.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@ClubCarActivity)
        }
        clubCalendarView.apply {
            setOnDateChangeListener { view, year, month, dayOfMonth ->
                info(dayOfMonth)
                adapter = ClubCalAdapter(viewModel.model.random(),this@ClubCarActivity)
                calRecyclerView.adapter = adapter
                calRecyclerView.adapter.notifyDataSetChanged()
            }
        }

    }
}
