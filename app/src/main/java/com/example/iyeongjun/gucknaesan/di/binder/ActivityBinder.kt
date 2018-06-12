package com.example.iyeongjun.gucknaesan.di.binder

import com.example.iyeongjun.gucknaesan.di.scope.PerActivity
import com.example.iyeongjun.gucknaesan.ui.main.MainActivity
import com.example.iyeongjun.gucknaesan.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder{
    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun bindMainActivity() : MainActivity


    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun bindSplashActivity() : SplashActivity
}