package com.example.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Badge(
    val backstage: Boolean?,
    val commingsoon: Boolean?,
    val exclusive: Boolean?,
    val free: Boolean?,
    val hear: Boolean?,
    val online_release: Boolean?,
    val vision: Boolean?
):Parcelable