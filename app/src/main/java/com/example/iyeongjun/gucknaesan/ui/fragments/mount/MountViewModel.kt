package com.example.iyeongjun.gucknaesan.ui.fragments.mount

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.arch.TourApi
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.api.model.tour.TourModel
import io.reactivex.subjects.BehaviorSubject

class MountViewModel(val driver : BehaviorSubject<MountModel>,
                     val sendDriver : BehaviorSubject<Item>,
                     val context : Context,
                     val clickDriver : BehaviorSubject<String>,
                     val tourDriver : BehaviorSubject<TourModel>,
                     val tourApi: TourApi) : ViewModel(){
    val province = listOf("전체","서울","인천","경기","대전","대구","울산","부산","광주","강원도","충청북도","충청남도","경상북도","경상남도","전라북도","전라남도","제주도")
    val mountModel : List<Item>
    get() {
        lateinit var temp : List<Item>
        driver.subscribe{ temp = it.items}
        return temp
    }
}