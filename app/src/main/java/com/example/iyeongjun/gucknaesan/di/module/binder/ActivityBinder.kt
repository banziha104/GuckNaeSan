package com.example.iyeongjun.gucknaesan.di.module.binder

import com.example.iyeongjun.gucknaesan.di.module.binder.ui.MainModule
import com.example.iyeongjun.gucknaesan.di.module.binder.ui.SplashModule
import com.example.iyeongjun.gucknaesan.ui.activities.main.MainActivity
import com.example.iyeongjun.gucknaesan.ui.activities.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder{
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity() : MainActivity


    @ContributesAndroidInjector(modules = arrayOf(SplashModule::class))
    abstract fun bindSplashActivity() : SplashActivity
}