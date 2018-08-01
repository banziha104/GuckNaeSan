package com.example.iyeongjun.gucknaesan.ui.activities.splash

import android.arch.lifecycle.ViewModel
import com.example.iyeongjun.gucknaesan.api.arch.GovApi
import com.example.iyeongjun.gucknaesan.api.arch.TourApi
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.gov.GovModel
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.api.model.tour.TourModel
import io.reactivex.Observable

class SplashViewModel(val api : GovApi,
                      val model : MountModel,
                      val clubModel: ClubModel,
                      val tourApi : TourApi) : ViewModel(){
    val govModel : Observable<GovModel>
        get() = api.getGovData()

    val requestTourApi : Observable<TourModel>
        get() = tourApi.getTourData()
}