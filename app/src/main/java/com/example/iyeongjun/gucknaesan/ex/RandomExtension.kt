package com.example.iyeongjun.gucknaesan.ex

import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import java.util.*
import kotlin.collections.ArrayList

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) +  start

fun MountModel.random() : ArrayList<Item>{
    var temp : ArrayList<Item> = arrayListOf()
    var randomNum : ArrayList<Int> = arrayListOf()
    var count = 0

    while (count < 12) {
        var canInsert = true
        var num = (0..100).random()
        for (i in randomNum) if(i == num) canInsert == false
        if(canInsert) {
            randomNum.add(num)
            count++
        }
    }
    for(i in randomNum) { temp.add(this.items[i]) }
    return temp
}