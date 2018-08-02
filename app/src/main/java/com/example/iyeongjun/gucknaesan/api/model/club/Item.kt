package com.example.iyeongjun.gucknaesan.api.model.club

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("clubName") var clubName: String,
    @SerializedName("address") var adress: String,
    @SerializedName("cafeUrl") var cafeUrl: String,
    @SerializedName("introduce") var cintroduce: String,
    @SerializedName("startPoint") var startPoint: String,
    @SerializedName("imgUrl") var imgUrl: String,
    @SerializedName(" province") var province: String
)