package com.example.iyeongjun.gucknaesan.ex

import com.example.iyeongjun.gucknaesan.rx.AutoClearedDisposable
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

operator fun AutoClearedDisposable.plusAssign(disposable: Disposable)
        = this.add(disposable)

fun runOnIoScheduler(func: () -> Unit): Disposable
        = Completable.fromCallable(func).subscribeOn(Schedulers.io()).subscribe()
