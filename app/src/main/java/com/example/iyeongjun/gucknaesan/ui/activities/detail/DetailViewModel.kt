package com.example.iyeongjun.gucknaesan.ui.activities.detail

import android.arch.lifecycle.ViewModel
import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.api.model.gov.GovModel
import com.example.iyeongjun.gucknaesan.api.model.govOneItem.OneGovModel
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class DetailViewModel(val driver : BehaviorSubject<Item>, val api : GovApi) : ViewModel()