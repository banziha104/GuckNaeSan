package com.example.iyeongjun.gucknaesan.ui.activities.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.iyeongjun.gucknaesan.api.arch.GovApi

class MainViewModelFactory(val api : GovApi) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(api) as T
    }

}