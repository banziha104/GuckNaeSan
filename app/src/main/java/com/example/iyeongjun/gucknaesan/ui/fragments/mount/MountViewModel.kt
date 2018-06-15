package com.example.iyeongjun.gucknaesan.ui.fragments.mount

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import io.reactivex.subjects.BehaviorSubject

class MountViewModel(val driver : BehaviorSubject<MountModel>,val sendDriver : BehaviorSubject<Item>, val context : Context) : ViewModel(){
    val mountModel : List<Item>
    get() {
        lateinit var temp : List<Item>
        driver.subscribe{ temp = it.items}
        return temp
    }
}