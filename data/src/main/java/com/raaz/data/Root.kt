package com.raaz.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Root(
    var id: Int = 0,
    var name: String? = null,
    var email: String? = null): Parcelable