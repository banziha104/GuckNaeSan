package com.example.iyeongjun.gucknaesan.ui.dialogs

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import com.example.iyeongjun.gucknaesan.R

class ConfirmDialog(var activity: Activity?) : Dialog(activity), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_confirm)
    }

    override fun onClick(v: View) {
        dismiss()
    }
}