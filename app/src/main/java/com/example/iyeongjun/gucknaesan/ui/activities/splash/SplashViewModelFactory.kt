package com.example.iyeongjun.gucknaesan.ui.activities.splash

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel

class SplashViewModelFactory(val api : GovApi, val model : MountModel, val clubModel : ClubModel) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashViewModel(api, model, clubModel) as T
    }

}