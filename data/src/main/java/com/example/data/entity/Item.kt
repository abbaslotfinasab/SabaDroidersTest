package com.example.data.entity

import android.os.Parcelable
import com.example.data.base.ResponseObject
import com.example.domain.models.ItemModel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Item(
    val attributes: @RawValue @Contextual Attributes?,
    val id: Int?,
    val type: String?
):Parcelable,ResponseObject<ItemModel> {
    override fun toDomain(): ItemModel {
        return ItemModel(attributes?.toDomain(),id,type)
    }
}