package com.example.iyeongjun.gucknaesan.di.component

import android.content.Context
import com.example.iyeongjun.gucknaesan.ForestApp
import com.example.iyeongjun.gucknaesan.di.module.ApiModule
import com.example.iyeongjun.gucknaesan.di.module.ContextModule
import com.example.iyeongjun.gucknaesan.di.module.DataModule
import com.example.iyeongjun.gucknaesan.di.module.DriverModule
import com.example.iyeongjun.gucknaesan.di.module.binder.ui.activities.ActivityBinder
import com.example.iyeongjun.gucknaesan.di.module.binder.ui.fragments.FragmentBinder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivityBinder::class,
        FragmentBinder::class,
        ContextModule::class,
        ApiModule::class,
        DataModule::class,
        DriverModule::class
))
interface AppComponent : AndroidInjector<ForestApp>{

    @Component.Builder
    interface Buidler{

        @BindsInstance
        fun application(app : Context) : Buidler
        fun build() : AppComponent
    }
}