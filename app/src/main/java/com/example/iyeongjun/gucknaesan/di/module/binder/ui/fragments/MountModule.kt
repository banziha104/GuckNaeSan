package com.example.iyeongjun.gucknaesan.di.module.binder.ui.fragments

import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ui.fragments.mount.MountViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject

@Module
class MountModule{
    @Provides
    fun provideMountViewModelFactory(driver : BehaviorSubject<MountModel>,
                                     sendDriver : BehaviorSubject<Item>,
                                     context : Context) : MountViewModelFactory = MountViewModelFactory(driver,sendDriver,context)
}