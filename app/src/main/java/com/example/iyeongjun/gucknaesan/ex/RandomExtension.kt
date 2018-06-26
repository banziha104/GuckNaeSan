package com.example.iyeongjun.gucknaesan.ex

import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.api.model.mount.MountModel
import java.util.*

fun ClosedRange<Int>.random() = Random().nextInt(endInclusive - start) + start
fun MountModel.random2(): ArrayList<Item> {
    var temp: ArrayList<Item> = arrayListOf()
    var randomNum: ArrayList<Int> = arrayListOf()
    var count = 0

    while (count < 3) {
        var canInsert = true
        var num = (0..100).random()
        for (i in randomNum) if (i == num) canInsert = false
        if (canInsert) {
            randomNum.add(num)
            count++
        }
    }
    for (i in randomNum) {
        temp.add(this.items[i])
    }
    return temp
}

fun MountModel.random(): ArrayList<Item> {
    var temp: ArrayList<Item> = arrayListOf()
    var randomNum: ArrayList<Int> = arrayListOf()
    var count = 0

    while (count < 12) {
        var canInsert = true
        var num = (0..100).random()
        for (i in randomNum) if (i == num) canInsert = false
        if (canInsert) {
            randomNum.add(num)
            count++
        }
    }
    for (i in randomNum) {
        temp.add(this.items[i])
    }
    return temp
}

fun List<com.example.iyeongjun.gucknaesan.api.model.club.Item>.random(): List<com.example.iyeongjun.gucknaesan.api.model.club.Item> {
    var tempData : ArrayList<com.example.iyeongjun.gucknaesan.api.model.club.Item> = arrayListOf()
    var randomNum: ArrayList<Int> = arrayListOf()
    var count = 0

    while (count < 12) {
        var canInsert = true
        var num = (0..size).random()
        for (i in randomNum){
            if (i == num) canInsert = false
        }
        if (canInsert) {
            randomNum.add(num)
            count++
        }
    }
    for ( i in randomNum){
        tempData.add(this[i])
    }
    return tempData
}