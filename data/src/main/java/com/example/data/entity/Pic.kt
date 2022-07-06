package com.example.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Pic(
    val movie_img_b: String?,
    val movie_img_m: String?,
    val movie_img_s: String?
):Parcelable