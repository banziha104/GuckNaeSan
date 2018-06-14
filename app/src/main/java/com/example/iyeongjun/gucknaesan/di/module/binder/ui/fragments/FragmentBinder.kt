package com.example.iyeongjun.gucknaesan.di.module.binder.ui.fragments

import com.example.iyeongjun.gucknaesan.ui.fragments.club.ClubFragment
import com.example.iyeongjun.gucknaesan.ui.fragments.mount.MountFragment
import com.example.iyeongjun.gucknaesan.ui.fragments.reco.RecoFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBinder{
    @ContributesAndroidInjector(modules = arrayOf(ClubModule::class))
    abstract fun bindClubFragment() : ClubFragment

    @ContributesAndroidInjector(modules = arrayOf(MountModule::class))
    abstract fun bindMountFragment() : MountFragment

    @ContributesAndroidInjector(modules = arrayOf(RecoModule::class))
    abstract fun bindUserFragment() : RecoFragment

}