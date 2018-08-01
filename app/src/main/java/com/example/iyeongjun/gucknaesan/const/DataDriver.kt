package com.example.iyeongjun.gucknaesan.const

import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import io.reactivex.subjects.BehaviorSubject

object DataDriver {
    val mountToCal = BehaviorSubject.create<Item>()
    val clubToCal = BehaviorSubject.create<com.example.iyeongjun.gucknaesan.api.model.club.Item>()
    val clubProDriver = BehaviorSubject.createDefault<String>("전체")
    val mountProDriver = BehaviorSubject.createDefault<String>("전체")
    val tutoDriver = BehaviorSubject.create<Int>()
}