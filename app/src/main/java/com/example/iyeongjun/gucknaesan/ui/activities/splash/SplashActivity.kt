package com.example.iyeongjun.gucknaesan.ui.activities.splash

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.ui.activities.main.MainActivity
import com.example.iyeongjun.gucknaesan.util.PermissionController
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(), AnkoLogger, PermissionController.CallBack{


    @Inject lateinit var viewModelFactory: SplashViewModelFactory
    private lateinit var viewModel : SplashViewModel

    override fun init() {
        viewModel = ViewModelProviders.of(this,viewModelFactory)[SplashViewModel::class.java]
        viewModel.govModel
                .subscribe{
            info(it)
            startActivity<MainActivity>()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        PermissionController(this, arrayOf()).checkVersion()
    }

}