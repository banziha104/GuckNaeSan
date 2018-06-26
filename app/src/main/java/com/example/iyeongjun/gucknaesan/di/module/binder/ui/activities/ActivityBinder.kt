package com.example.iyeongjun.gucknaesan.di.module.binder.ui.activities

import com.example.iyeongjun.gucknaesan.ui.activities.cal.CalActivity
import com.example.iyeongjun.gucknaesan.ui.activities.club.ClubDetailActivity
import com.example.iyeongjun.gucknaesan.ui.activities.clubCar.ClubCarActivity
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

    @ContributesAndroidInjector(modules = arrayOf(CalModule::class))
    abstract fun bindCalActivity() : CalActivity

    @ContributesAndroidInjector(modules = arrayOf(DetailModule::class))
    abstract fun bindDetailActivity() : DetailActivity

    @ContributesAndroidInjector(modules = arrayOf(ClubDetailModule::class))
    abstract fun bindClubDetail() : ClubDetailActivity

    @ContributesAndroidInjector(modules = arrayOf(ClubCalModule::class))
    abstract fun bindClubCarActivity() : ClubCarActivity
}