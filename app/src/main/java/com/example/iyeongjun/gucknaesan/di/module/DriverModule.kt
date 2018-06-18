package com.example.iyeongjun.gucknaesan.di.module

import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.gov.GovModel
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
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

    @Provides
    @Singleton
    fun provideItemDriver() = BehaviorSubject.create<Item>()

    @Provides
    @Singleton
    fun provideClubItemDriver() = BehaviorSubject.create<com.example.iyeongjun.gucknaesan.api.model.club.Item>()

    @Provides
    @Singleton
    fun provideClubDataDriver() = BehaviorSubject.create<ClubModel>()

}