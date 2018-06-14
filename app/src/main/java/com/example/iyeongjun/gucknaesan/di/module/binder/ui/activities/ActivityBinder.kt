package com.example.iyeongjun.gucknaesan.di.module.binder.ui.activities

import android.app.ListActivity
import com.example.iyeongjun.gucknaesan.ui.activities.detail.DetailActivity
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

    @ContributesAndroidInjector(modules = arrayOf(ListModule::class))
    abstract fun bindListActivity() : ListActivity

    @ContributesAndroidInjector(modules = arrayOf(DetailModule::class))
    abstract fun bindDetailActivity() : DetailActivity
}