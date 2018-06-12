package com.example.iyeongjun.gucknaesan.ui.splash

import com.example.iyeongjun.gucknaesan.api.model.GovModel
import io.reactivex.Observable

class SplashViewModel(val api : Observable<GovModel>){
    val govModel : Observable<GovModel>
    get() = api
}