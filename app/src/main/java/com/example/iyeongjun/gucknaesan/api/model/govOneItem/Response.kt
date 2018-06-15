package com.example.iyeongjun.gucknaesan.api.model.govOneItem

import com.google.gson.annotations.SerializedName
data class Response(
    @SerializedName("header") var header: Header,
    @SerializedName("body") var body: Body
)