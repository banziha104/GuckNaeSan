package com.example.iyeongjun.gucknaesan.ui.fragments.reco

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import com.example.iyeongjun.gucknaesan.ex.random
import io.reactivex.subjects.BehaviorSubject

class RecoViewModel(val driver : BehaviorSubject<MountModel>,val sendDriver : BehaviorSubject<Item>, val context: Context ) : ViewModel(){
    val mountModel : ArrayList<Item>
    get() {
        lateinit var temp : ArrayList<Item>
        driver.subscribe{
            temp = it.random()
        }
        return temp
    }
}