package com.example.iyeongjun.gucknaesan.ui.activities.club

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.iyeongjun.gucknaesan.api.model.club.Item
import io.reactivex.subjects.BehaviorSubject

class ClubDetailViewModelFactory(val driver : BehaviorSubject<Item>) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ClubDetailViewModel(driver) as T
    }

}