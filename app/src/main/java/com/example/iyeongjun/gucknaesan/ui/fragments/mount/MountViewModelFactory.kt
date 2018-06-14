package com.example.iyeongjun.gucknaesan.ui.fragments.mount

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.arch.GovApi

class MountViewModelFactory(val api : GovApi , val context: Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHACKED")
        return MountViewModel(api,context) as T
    }
}