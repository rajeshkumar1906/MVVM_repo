package com.raaz.domain.model.openlib


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class OpenLibData(
    @SerializedName("docs")
    val docs: List<DocX> = listOf(),
    @SerializedName("numFound")
    val numFound: Int = 0,
    @SerializedName("num_found")
    val numFound1: Int = 0,
    @SerializedName("numFoundExact")
    val numFoundExact: Boolean = false,
    @SerializedName("offset")
    val offset: Any = Any(),
    @SerializedName("q")
    val q: String = "",
    @SerializedName("start")
    val start: Int = 0
)