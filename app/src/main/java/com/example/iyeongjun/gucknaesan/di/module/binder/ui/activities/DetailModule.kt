package com.example.iyeongjun.gucknaesan.di.module.binder.ui.activities

import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.tour.TourModel
import com.example.iyeongjun.gucknaesan.ui.activities.detail.DetailViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject

@Module
class DetailModule{
    @Provides
    fun provideDetailViewModelFactory(driver : BehaviorSubject<Item>,
                                      api : GovApi,
                                      tourDriver : BehaviorSubject<TourModel>)
    = DetailViewModelFactory(driver,api,tourDriver)
}