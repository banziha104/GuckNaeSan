package com.example.iyeongjun.gucknaesan.di.module.binder.ui.fragments

import android.content.Context
import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.ui.fragments.mount.MountViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MountModule{
    @Provides
    fun provideMountViewModelFactory(api : GovApi, context : Context) : MountViewModelFactory = MountViewModelFactory(api,context)
}