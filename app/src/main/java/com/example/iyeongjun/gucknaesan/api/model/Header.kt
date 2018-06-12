package com.example.iyeongjun.gucknaesan.api.model

import com.google.gson.annotations.SerializedName
data class Header(
    @SerializedName("resultCode") var resultCode: String?,
    @SerializedName("resultMsg") var resultMsg: String?
)