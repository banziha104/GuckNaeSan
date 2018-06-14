package com.example.iyeongjun.gucknaesan.ui.fragments.reco

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import io.reactivex.subjects.BehaviorSubject

class RecoViewModel(val driver : BehaviorSubject<MountModel>, val context: Context ) : ViewModel()