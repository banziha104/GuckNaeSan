package com.example.iyeongjun.gucknaesan.ui.dialogs

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import com.example.iyeongjun.gucknaesan.R
import com.example.iyeongjun.gucknaesan.api.model.mount.Item
import com.example.iyeongjun.gucknaesan.ui.GlideApp
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.dialog_confirm.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class ConfirmDialog(var activity: Activity?,
                    val mountItem : Item,
                    val clubItem : com.example.iyeongjun.gucknaesan.api.model.club.Item,
                    val date : Array<Int>,
                    val driver : BehaviorSubject<com.example.iyeongjun.gucknaesan.api.model.club.Item>) : Dialog(activity), View.OnClickListener , AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_confirm)
        info { "카페주소입니다아아아 ${clubItem.cafeUrl}"  }
        txtDia.text =
                "${date[0]} 월 ${date[1]} 일 \n ${mountItem.mtName} / ${clubItem.clubName} \n 신청하시겠습니까"

        GlideApp
                .with(activity)
                .load(clubItem.imgUrl)
                .circleCrop()
                .into(imgDiaClub)

        GlideApp
                .with(activity)
                .load(mountItem.imgUrl)
                .circleCrop()
                .into(imgDiaMount)

        btnDiaBand.setOnClickListener { activity?.toast("해당 산악회에서 밴드 연동이 안되어있습니다.") }
        btnDiaKakao.setOnClickListener { activity?.toast("해당 산악회에서 카카오톡 연동이 안되어있습니다.") }
        btnDiaWeb.setOnClickListener {
            driver.onNext(clubItem)
            dismiss()
         }
    }

    override fun onClick(v: View) {
        dismiss()
    }
}