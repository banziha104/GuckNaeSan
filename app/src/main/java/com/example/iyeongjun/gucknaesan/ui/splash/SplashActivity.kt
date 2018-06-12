package com.example.iyeongjun.gucknaesan.ui.splash

import android.os.Bundle
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.util.PermissionController
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(), AnkoLogger,PermissionController.CallBack {


    @Inject lateinit var api : GovApi

    override fun init() {
        api.getGovData().subscribe{
            info(it)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        PermissionController(this, arrayOf()).checkVersion()
    }
}
