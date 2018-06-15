package com.example.iyeongjun.gucknaesan.ui.fragments.reco

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import io.reactivex.subjects.BehaviorSubject

class RecoViewModelFactory(val model : BehaviorSubject<MountModel>, val sendDriver : BehaviorSubject<Item>, val context : Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHACK")
        return RecoViewModel(model,sendDriver,context) as T
    }
}