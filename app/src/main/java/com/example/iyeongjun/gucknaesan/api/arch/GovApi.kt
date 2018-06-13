package com.example.iyeongjun.gucknaesan.api.arch

import com.example.iyeongjun.gucknaesan.api.model.gov.GovModel
import com.example.iyeongjun.gucknaesan.const.AUTH_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GovApi{
    @GET("/1400000/service/cultureInfoService/mntInfoOpenAPI")
    fun getGovData(
            @Query("ServiceKey", encoded = true) serviceKey : String = AUTH_KEY,
            @Query("_type") _type : String = "json"
    ) : Observable<GovModel>
}