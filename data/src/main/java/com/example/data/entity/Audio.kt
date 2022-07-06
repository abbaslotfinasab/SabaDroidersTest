package com.example.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Audio(
    val isMultiLanguage: Boolean?,
    val languages: MutableList<String>?
):Parcelable