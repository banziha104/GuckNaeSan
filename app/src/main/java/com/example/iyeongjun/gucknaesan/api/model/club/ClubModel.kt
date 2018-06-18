package com.example.iyeongjun.gucknaesan.api.model.club

import com.google.gson.annotations.SerializedName

data class ClubModel(
    @SerializedName("items") var items: List<Item>
)