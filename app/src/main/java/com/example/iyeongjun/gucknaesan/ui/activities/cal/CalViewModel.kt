package com.example.iyeongjun.gucknaesan.ui.activities.cal

import android.arch.lifecycle.ViewModel
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import io.reactivex.subjects.BehaviorSubject

class CalViewModel(val driver : BehaviorSubject<Item>, val clubModel: ClubModel) : ViewModel()