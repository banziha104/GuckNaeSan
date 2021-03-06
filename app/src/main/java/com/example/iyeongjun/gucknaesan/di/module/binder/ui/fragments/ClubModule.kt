package com.example.iyeongjun.gucknaesan.di.module.binder.ui.fragments

import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.club.Item
import com.example.iyeongjun.gucknaesan.ui.fragments.club.ClubViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Named

@Module
class ClubModule{
    @Provides
    fun provideClubViewModelFactory(driver : BehaviorSubject<Item>,
                                    model : ClubModel,
                                    context: Context,
                                    @Named("club") clickDriver : BehaviorSubject<String>)
            = ClubViewModelFactory(driver,model,context,clickDriver)
}