package com.example.iyeongjun.gucknaesan.ui.activities.cal

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import io.reactivex.subjects.BehaviorSubject

class CalViewModelFactory(val driver : BehaviorSubject<Item>,val clubModel: ClubModel) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CalViewModel(driver,clubModel) as T
    }
}