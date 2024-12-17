package com.raaz.domain.model

import com.google.gson.annotations.SerializedName

data class Root(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("email")
    var email: String? = null)
