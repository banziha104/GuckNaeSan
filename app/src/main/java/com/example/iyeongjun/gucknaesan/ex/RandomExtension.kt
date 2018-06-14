package com.example.iyeongjun.gucknaesan.ex

import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import java.util.*
import kotlin.collections.ArrayList

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start

fun MountModel.random() : ArrayList<Item>{
    var temp : ArrayList<Item> = arrayListOf()
    var randomNum : ArrayList<Int> = arrayListOf()
    for(i in 0..10) { randomNum.add((0..100).random()) }
    for(i in randomNum) { temp.add(this.items[i]) }
    return temp
}