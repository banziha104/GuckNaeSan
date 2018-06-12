package com.example.iyeongjun.gucknaesan.di.component

import android.content.Context
import com.example.iyeongjun.gucknaesan.ForestApp
import com.example.iyeongjun.gucknaesan.di.binder.ActivityBinder
import com.example.iyeongjun.gucknaesan.di.module.ApiModule
import com.example.iyeongjun.gucknaesan.di.module.ContextModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivityBinder::class,
        ContextModule::class,
        ApiModule::class
))
interface AppComponent : AndroidInjector<ForestApp>{

    @Component.Builder
    interface Buidler{

        @BindsInstance
        fun application(app : Context) : Buidler
        fun build() : AppComponent
    }
}