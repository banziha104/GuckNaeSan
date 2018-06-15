package com.example.iyeongjun.gucknaesan.api.model.govOneItem

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("mntiadd") var mntiadd: String,
    @SerializedName("mntiadmin") var mntiadmin: String,
    @SerializedName("mntiadminnum") var mntiadminnum: String,
    @SerializedName("mntidetails") var mntidetails: String,
    @SerializedName("mntihigh") var mntihigh: Int,
    @SerializedName("mntilistno") var mntilistno: Long,
    @SerializedName("mntiname") var mntiname: String,
    @SerializedName("mntisname") var mntisname: String,
    @SerializedName("mntisummary") var mntisummary: String,
    @SerializedName("mntitop") var mntitop: String
)