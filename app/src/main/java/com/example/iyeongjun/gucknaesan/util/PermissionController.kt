package com.example.iyeongjun.gucknaesan.util

import android.annotation.TargetApi
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger

class PermissionController(val activity: AppCompatActivity, val permissions: Array<String>) : AnkoLogger {

    companion object {
        private val REQ_FLAG  = 10005
    }

    fun checkVersion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission()
        } else {
            callInit(activity)
        }
    }


    @TargetApi(Build.VERSION_CODES.M)
    private fun checkPermission() {
        var isGranted = true

        for (permssion in permissions) {
            if (activity.checkSelfPermission(permssion) != PackageManager.PERMISSION_GRANTED) {
                isGranted = false
                break
            }
        }

        if (!isGranted) {
            activity.requestPermissions(permissions, REQ_FLAG)
        } else{
            callInit(activity)
        }

    }

    private fun callInit(activity: Activity){
        if(activity is CallBack){
            (activity as CallBack).init()
        } else {
            throw RuntimeException("must implement this.CallBack")
        }
    }
    interface CallBack{
        fun init()
    }
}