package com.example.iyeongjun.gucknaesan.ex

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver

operator fun Lifecycle.plusAssign(observer: LifecycleObserver)
        = this.addObserver(observer)
