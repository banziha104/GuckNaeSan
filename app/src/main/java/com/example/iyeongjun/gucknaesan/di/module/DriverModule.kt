package com.example.iyeongjun.gucknaesan.di.module

import com.example.iyeongjun.gucknaesan.api.model.gov.GovModel
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Singleton


@Module
class DriverModule{
    @Provides
    @Singleton
    fun provideGovDataDriver() = BehaviorSubject.create<GovModel>()

    @Provides
    @Singleton
    fun provideMountDataDriver() = BehaviorSubject.create<MountModel>()

}