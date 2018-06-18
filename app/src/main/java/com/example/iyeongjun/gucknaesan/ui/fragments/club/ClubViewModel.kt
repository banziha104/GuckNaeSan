package com.example.iyeongjun.gucknaesan.ui.fragments.club

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.club.Item
import io.reactivex.subjects.BehaviorSubject

class ClubViewModel(val driver : BehaviorSubject<Item>,
                    val model : ClubModel,
                    val context : Context) : ViewModel(){
    val province = model.items.map { it.province }.distinct()
}