package com.example.iyeongjun.gucknaesan.di.module.binder.ui.activities

import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ui.activities.clubCar.ClubCarViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ClubCalModule{
    @Provides
    fun provideClubCarViewModelFactory(model :MountModel) = ClubCarViewModelFactory(model)
}