package com.example.iyeongjun.gucknaesan.di.module.binder.ui.activities

import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.ui.activities.main.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainModule{
    @Provides
    fun provideViewModelFactory(api : GovApi) : MainViewModelFactory
        = MainViewModelFactory(api)
}