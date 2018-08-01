package com.example.iyeongjun.gucknaesan.di.module

import com.example.iyeongjun.gucknaesan.api.local.clubJson
import com.example.iyeongjun.gucknaesan.api.local.mountJson1
import com.example.iyeongjun.gucknaesan.api.local.mountJson2
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataModule{
    @Singleton
    @Provides
    @Named("1")
    fun provideMountModel1() = Gson().fromJson(mountJson1,MountModel::class.java)

    @Singleton
    @Provides
    @Named("2")
    fun provideMountModel2() = Gson().fromJson(mountJson2,MountModel::class.java)


    @Singleton
    @Provides
    fun provideMountModel(@Named("1") mountModel1 : MountModel,
                          @Named("2") mountModel2 : MountModel) : MountModel{
        val temp = mountModel1.items as ArrayList
        temp.addAll(mountModel2.items)
        return MountModel(temp)
    }

    @Singleton
    @Provides
    fun provideClubModel() = Gson().fromJson(clubJson,ClubModel::class.java)
}