package com.example.iyeongjun.gucknaesan

import com.bumptech.glide.annotation.GlideModule
import com.example.iyeongjun.gucknaesan.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class ForestApp : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}