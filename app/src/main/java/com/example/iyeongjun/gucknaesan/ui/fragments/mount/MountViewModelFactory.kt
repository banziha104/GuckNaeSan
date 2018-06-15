package com.example.iyeongjun.gucknaesan.ui.fragments.mount

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import io.reactivex.subjects.BehaviorSubject

class MountViewModelFactory(val driver : BehaviorSubject<MountModel>, val sendDriver : BehaviorSubject<Item>, val context: Context) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHACKED")
        return MountViewModel(driver,sendDriver,context) as T
    }
}