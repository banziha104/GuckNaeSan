package com.example.iyeongjun.gucknaesan.ui.main

import android.arch.lifecycle.ViewModel
import com.example.iyeongjun.gucknaesan.api.model.GovModel
import io.reactivex.Observable

class MainViewModel(val api : Observable<GovModel>) : ViewModel(){
    val govModel : Observable<GovModel> = api
}