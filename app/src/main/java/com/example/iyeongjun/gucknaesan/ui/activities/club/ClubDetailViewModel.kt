package com.example.iyeongjun.gucknaesan.ui.activities.club

import android.arch.lifecycle.ViewModel
import com.example.iyeongjun.gucknaesan.api.model.club.Item
import io.reactivex.subjects.BehaviorSubject

class ClubDetailViewModel(val driver : BehaviorSubject<Item>) : ViewModel()