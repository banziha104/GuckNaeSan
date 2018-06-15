package com.example.iyeongjun.gucknaesan.api.model.gov

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("mntiadd") var mntiadd: String?,
    @SerializedName("mntiadmin") var mntiadmin: String?,
    @SerializedName("mntiadminnum") var mntiadminnum: String?,
    @SerializedName("mntidetails") var mntidetails: String?,
    @SerializedName("mntihigh") var mntihigh: String?,
    @SerializedName("mntilistno") var mntilistno: String?,
    @SerializedName("mntiname") var mntiname: String?,
    @SerializedName("mntisname") var mntisname: String?,
    @SerializedName("mntisummary") var mntisummary: String?,
    @SerializedName("mntitop") var mntitop: String?
)