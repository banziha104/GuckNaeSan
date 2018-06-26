package com.example.iyeongjun.gucknaesan.ui.activities.clubCar

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel

class ClubCarViewModelFactory(val model : MountModel) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ClubCarViewModel(model) as T
    }

}