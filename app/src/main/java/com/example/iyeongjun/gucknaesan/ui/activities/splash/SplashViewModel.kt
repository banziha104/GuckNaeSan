package com.example.iyeongjun.gucknaesan.ui.activities.splash

import android.arch.lifecycle.ViewModel
import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.api.model.GovModel
import io.reactivex.Observable

class SplashViewModel(val api : GovApi) : ViewModel(){
    val govModel : Observable<GovModel>
        get() = api.getGovData()
}