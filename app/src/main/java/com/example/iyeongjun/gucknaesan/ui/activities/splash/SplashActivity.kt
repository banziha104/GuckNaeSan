package com.example.iyeongjun.gucknaesan.ui.activities.splash

import android.Manifest
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.gov.GovModel
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ex.plusAssign
import com.example.iyeongjun.gucknaesan.rx.AutoClearedDisposable
import com.example.iyeongjun.gucknaesan.ui.activities.main.MainActivity
import com.example.iyeongjun.gucknaesan.ui.activities.tuto.TutoActivity
import com.example.iyeongjun.gucknaesan.util.PermissionController
import com.yqritc.scalablevideoview.ScalableType
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(), AnkoLogger, PermissionController.CallBack {

    @Inject
    lateinit var viewModelFactory: SplashViewModelFactory
    @Inject
    lateinit var govDriver: BehaviorSubject<GovModel>
    @Inject
    lateinit var mountDriver: BehaviorSubject<MountModel>
    @Inject
    lateinit var clubDriver: BehaviorSubject<ClubModel>
    private lateinit var viewModel: SplashViewModel
    val disposable = AutoClearedDisposable(this)
    val viewDisposables = AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)

    override fun init() {
        lifecycle += viewDisposables
        viewModel = ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]
        viewDisposables += viewModel.govModel
                .subscribe({
                    govDriver.onNext(it)
                }, {
                    it.printStackTrace()
                })
        viewDisposables += viewModel.requestTourApi
                .subscribe({
                    info { "시작하자 ${it.body.items.size}" }
                }, {
                    it.printStackTrace()
                })
        clubDriver.onNext(viewModel.clubModel)
        info(viewModel.clubModel)
        mountDriver.onNext(viewModel.model)
        val hd = Handler()
        hd.postDelayed({
            startActivity<TutoActivity>()
            finish()
        },3000)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        PermissionController(this, arrayOf(Manifest.permission.INTERNET)).checkVersion()
    }
    override fun onResume() {
        super.onResume()
        splashVideo2.setRawData(R.raw.splash)
        splashVideo2.requestFocus()
        splashVideo2.setScalableType(ScalableType.FIT_XY)
        splashVideo2.prepareAsync{
            it.start()
        }
    }
}