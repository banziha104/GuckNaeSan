package com.example.iyeongjun.gucknaesan.ui.activities.detail

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import io.reactivex.subjects.BehaviorSubject

class DetailViewModelFactory(val driver : BehaviorSubject<Item>, val api : GovApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         return DetailViewModel(driver,api) as T
    }

}