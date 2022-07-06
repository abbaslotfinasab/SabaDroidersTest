package com.example.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Category(
    val link_key: String?,
    val link_type: String?,
    val title: String?,
    val title_en: String?
):Parcelable