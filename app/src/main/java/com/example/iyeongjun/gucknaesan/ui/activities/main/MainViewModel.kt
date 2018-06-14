package com.example.iyeongjun.gucknaesan.ui.activities.main

import android.arch.lifecycle.ViewModel
import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.api.model.gov.GovModel
import io.reactivex.Observable

class MainViewModel(val api : GovApi) : ViewModel(){
    val govModel : Observable<GovModel>
        get() = api.getGovData()
//    fun getGovmodel(mtName : String?) : Observable<GovModel>{
//        mtName.let {
//            return api.getGovData(it)
//        }?.let {
//            return api
//        }
//    }
}