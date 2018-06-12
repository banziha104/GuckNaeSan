package com.example.iyeongjun.gucknaesan.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.iyeongjun.gucknaesan.api.model.GovModel
import io.reactivex.Observable

class MainViewModelFactory(val api : Observable<GovModel>) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(api) as T
    }

}