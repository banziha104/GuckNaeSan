package com.example.iyeongjun.gucknaesan.di.module.binder.ui.activities

import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.ui.activities.cal.CalViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject

@Module
class CalModule{
    @Provides
    fun provideCalViewModelFactory(driver : BehaviorSubject<Item>, clubModel: ClubModel)
            = CalViewModelFactory(driver,clubModel)
}