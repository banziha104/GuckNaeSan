package com.example.iyeongjun.gucknaesan.api.model.mount

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("no") var no: Int,
    @SerializedName("mtName") var mtName: String,
    @SerializedName("height") var height: Double,
    @SerializedName("description") var description: String,
    @SerializedName("imgUrl") var imgUrl : String,
    @SerializedName("lon") var lat : Double,
    @SerializedName("lan") var lon : Double,
    @SerializedName("address") var address : String,
    @SerializedName("province") var province : String
)