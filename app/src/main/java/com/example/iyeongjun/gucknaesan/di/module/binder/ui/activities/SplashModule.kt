package com.example.iyeongjun.gucknaesan.di.module.binder.ui.activities

import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.api.arch.TourApi
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ui.activities.splash.SplashViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SplashModule{
    @Provides
    fun provideViewModelFactory(api : GovApi, model : MountModel, clubModel: ClubModel, tourApi : TourApi)
            = SplashViewModelFactory(api,model,clubModel,tourApi)
}