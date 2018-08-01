package com.example.iyeongjun.gucknaesan.ui.fragments.club

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.club.Item
import io.reactivex.subjects.BehaviorSubject

class ClubViewModelFactory(val driver : BehaviorSubject<Item>,
                           val model : ClubModel,
                           val context : Context,
                           val clickDriver : BehaviorSubject<String>) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ClubViewModel(driver,model,context,clickDriver) as T
    }

}