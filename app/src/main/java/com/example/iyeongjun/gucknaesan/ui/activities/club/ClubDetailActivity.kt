package com.example.iyeongjun.gucknaesan.ui.activities.club

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.const.DataDriver.clubToCal
import com.example.iyeongjun.gucknaesan.ex.plusAssign
import com.example.iyeongjun.gucknaesan.rx.AutoClearedDisposable
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import com.example.iyeongjun.gucknaesan.ui.activities.clubCar.ClubCarActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_club_detail.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class ClubDetailActivity : DaggerAppCompatActivity(),AnkoLogger {
    @Inject lateinit var viewModelFactory: ClubDetailViewModelFactory
    lateinit var viewModel : ClubDetailViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this,alwaysClearOnStop = false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club_detail)
        viewModel = ViewModelProviders.of(this,viewModelFactory)[ClubDetailViewModel::class.java]
        lifecycle += disposable
        lifecycle += viewDisposables
        bind()
    }

    fun bind(){
        viewDisposables += viewModel.driver.subscribe{
            clubToCal.onNext(it)
            txtClubDetailAddress.text = "   {fa-map-marker}  활동지  :  ${it.province}"
            txtClubDetailCafe.text = "   {fa-coffee}  카페주소  :  http://${it.cafeUrl}"
            txtClubDetailStartPoint.text = "   {fa-flag}  시작점  :  ${it.startPoint}"
            txtClubDetailSubTitle.text = "   {fa-tag}  산악회명  :  ${it.clubName}"
            txtClubDetailTitle.text = it.clubName
            txtClubDetailDes.text = it.cintroduce + "\n \n \n"
            GlideApp.with(this)
                    .load(it.imgUrl)
                    .into(imgClubDetail)
            txtClubDetailCafe.setOnClickListener {view ->
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("${it.cafeUrl}")))
            }
        }
        btnClubDetail.setOnClickListener {
            startActivity<ClubCarActivity>()
        }
    }
}
