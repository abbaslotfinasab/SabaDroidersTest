package com.example.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class RelData(
    val rel_id: String?,
    val rel_type: String?,
    val rel_type_txt: String?,
):Parcelable