package com.example.iyeongjun.gucknaesan.di.module

import com.example.iyeongjun.gucknaesan.api.local.mountJson
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule{
    @Singleton
    @Provides
    fun provideMountModel() = Gson().fromJson(mountJson,MountModel::class.java)
}