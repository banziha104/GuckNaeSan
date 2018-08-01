package com.example.iyeongjun.gucknaesan.ui.fragments.reco

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.arch.TourApi
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.api.model.tour.TourModel
import io.reactivex.subjects.BehaviorSubject

class RecoViewModelFactory(val model : BehaviorSubject<MountModel>,
                           val sendDriver : BehaviorSubject<Item>,
                           val context : Context,
                           val tourDriver : BehaviorSubject<TourModel>,
                           val tourApi: TourApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHACK")
        return RecoViewModel(model,sendDriver,context,tourDriver,tourApi) as T
    }
}