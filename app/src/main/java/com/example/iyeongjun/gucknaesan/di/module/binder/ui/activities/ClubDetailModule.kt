package com.example.iyeongjun.gucknaesan.di.module.binder.ui.activities

import com.example.iyeongjun.gucknaesan.api.model.club.Item
import com.example.iyeongjun.gucknaesan.ui.activities.club.ClubDetailViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject

@Module
class ClubDetailModule{
    @Provides
    fun provideClubDetailViewModelFactory(driver : BehaviorSubject<Item>) = ClubDetailViewModelFactory(driver)
}