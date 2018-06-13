package com.example.iyeongjun.gucknaesan.api.model.mount

import com.google.gson.annotations.SerializedName

data class MountModel(
    @SerializedName("items") var items: List<Item>
)