package com.example.iyeongjun.gucknaesan.api.model.mount

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("no") var no: Int,
    @SerializedName("mtName") var mtName: String,
    @SerializedName("height") var height: Double,
    @SerializedName("description") var description: String,
    @SerializedName("imgUrl") var imgUrl : String,
    @SerializedName("lat") var lat : Double,
    @SerializedName("lon") var lon : Double,
    @SerializedName("address") var address : String,
    @SerializedName("province") var province : String

)