package com.example.iyeongjun.gucknaesan.api.model.mount

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("no") var no: Int,
    @SerializedName("mtName") var mtName: String,
    @SerializedName("height") var height: Double,
    @SerializedName("description") var description: String
)