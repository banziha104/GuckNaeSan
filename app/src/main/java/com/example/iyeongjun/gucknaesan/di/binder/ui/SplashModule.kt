package com.example.iyeongjun.gucknaesan.di.binder.ui

import com.example.iyeongjun.gucknaesan.api.model.GovModel
import com.example.iyeongjun.gucknaesan.ui.splash.SplashViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

@Module
class SplashModule{
    @Provides
    fun provideViewModelFactory(api : Observable<GovModel>) : SplashViewModelFactory
            = SplashViewModelFactory(api)
}