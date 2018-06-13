package com.example.iyeongjun.gucknaesan.di.module.binder.ui.activities

import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.ui.activities.splash.SplashViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SplashModule{
    @Provides
    fun provideViewModelFactory(api : GovApi) : SplashViewModelFactory
            = SplashViewModelFactory(api)
}