package com.example.iyeongjun.gucknaesan.di.module.binder.ui.fragments

import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ui.fragments.reco.RecoViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject

@Module
class RecoModule{
    @Provides
    fun provideRecoViewModelFactory(driver : BehaviorSubject<MountModel>, context : Context)
            = RecoViewModelFactory(driver,context)
}