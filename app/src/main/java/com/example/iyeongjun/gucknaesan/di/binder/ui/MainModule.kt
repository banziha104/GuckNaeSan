package com.example.iyeongjun.gucknaesan.di.binder.ui

import com.example.iyeongjun.gucknaesan.api.model.GovModel
import com.example.iyeongjun.gucknaesan.ui.main.MainViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

@Module
class MainModule{
    @Provides
    fun provideViewModelFactory(api : Observable<GovModel>) : MainViewModelFactory
     =MainViewModelFactory(api)
}