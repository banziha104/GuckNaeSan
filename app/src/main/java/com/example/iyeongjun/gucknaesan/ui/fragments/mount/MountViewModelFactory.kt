package com.example.iyeongjun.gucknaesan.ui.fragments.mount

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.arch.TourApi
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.api.model.tour.TourModel
import io.reactivex.subjects.BehaviorSubject

class MountViewModelFactory(val driver : BehaviorSubject<MountModel>,
                            val sendDriver : BehaviorSubject<Item>,
                            val context: Context,
                            val clickDriver : BehaviorSubject<String>,
                            val tourDriver : BehaviorSubject<TourModel>,
                            val tourApi: TourApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHACKED")
        return MountViewModel(driver,sendDriver,context,clickDriver,tourDriver,tourApi) as T
    }
}