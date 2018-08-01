package com.example.iyeongjun.gucknaesan.ui.activities.detail

import android.arch.lifecycle.ViewModel
import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.tour.TourModel
import io.reactivex.subjects.BehaviorSubject

class DetailViewModel(val driver : BehaviorSubject<Item>,
                      val api : GovApi,
                      val tourDriver : BehaviorSubject<TourModel>) : ViewModel()