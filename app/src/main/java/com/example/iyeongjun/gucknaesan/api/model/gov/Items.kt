package com.example.iyeongjun.gucknaesan.api.model.gov

import com.google.gson.annotations.SerializedName
data class Items(
    @SerializedName("item") var item: List<Item>?
)