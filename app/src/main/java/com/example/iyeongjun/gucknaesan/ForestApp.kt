package com.example.iyeongjun.gucknaesan

import com.example.iyeongjun.gucknaesan.di.component.DaggerAppComponent
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import com.joanzapata.iconify.Iconify
import com.joanzapata.iconify.fonts.FontAwesomeModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class ForestApp : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
    override fun onCreate() {
        super.onCreate()
        Iconify.with(FontAwesomeModule())
    }

    override fun onLowMemory() {
        super.onLowMemory()
        GlideApp.get(this).clearMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        GlideApp.get(this).trimMemory(level)
    }
}