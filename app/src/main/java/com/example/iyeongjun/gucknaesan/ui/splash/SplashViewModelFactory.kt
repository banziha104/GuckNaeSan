package com.example.iyeongjun.gucknaesan.ui.splash

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.iyeongjun.gucknaesan.api.model.GovModel
import io.reactivex.Observable


class SplashViewModelFactory(val api : Observable<GovModel>) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress
        return SplashViewModel(api) as T
    }

}