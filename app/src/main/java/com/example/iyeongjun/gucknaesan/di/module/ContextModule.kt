package com.example.iyeongjun.gucknaesan.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ContextModule{
    @Provides
    @Named("appContext")
    @Singleton
    fun provideContext(application: Application) = application.applicationContext
}