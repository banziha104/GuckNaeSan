package com.example.iyeongjun.gucknaesan.ui.fragments.club

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.club.ClubModel
import com.example.iyeongjun.gucknaesan.api.model.club.Item
import io.reactivex.subjects.BehaviorSubject

class ClubViewModel(val driver : BehaviorSubject<Item>,
                    val model : ClubModel,
                    val context : Context,
                    val clickDriver : BehaviorSubject<String>) : ViewModel(){
    val province = listOf("전체","서울","인천","경기","대전","대구","울산","부산","광주","강원도","충청북도","충청남도","경상북도","경상남도","전라북도","전라남도","제주도")
}