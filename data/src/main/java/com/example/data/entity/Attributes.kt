package com.example.data.entity

import android.os.Parcelable
import com.example.data.base.ResponseObject
import com.example.domain.models.AttributeModel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Attributes(
    val HD: Boolean?,
    val age_range: String?,
    val audio: @RawValue @Contextual Audio?,
    val avg_rate_label: String?,
    val badge:@RawValue @Contextual Badge?,
    val categories: @RawValue @Contextual List<Category>?,
    val commingsoon_txt: String?,
    val countries: @RawValue @Contextual List<Country>?,
    val cover: String?,
    val descr: String?,
    val director: String?,
    val dubbed: @RawValue @Contextual Dubbed?,
    val duration: @RawValue @Contextual Duration?,
    val freemium: Boolean?,
    val imdb_rate: String?,
    val language_info: @RawValue @Contextual LanguageInfo?,
    val link_key: String?,
    val link_type: String?,
    val movie_id: String?,
    val movie_title: String?,
    val movie_title_en: String?,
    val output_type: String?,
    val pic: @RawValue @Contextual Pic?,
    val position: Int?,
    val pro_year: String?,
    val publish_date: String?,
    val rate_avrage: String?,
    val rate_enable: Boolean?,
    val rel_data:@RawValue @Contextual RelData?,
    val serial: @RawValue @Contextual Serial?,
    val sid: Int?,
    val subtitle: @RawValue @Contextual Subtitle?,
    val tag_id:@RawValue @Contextual Any,
    val theme: String?,
    val uid: String?,
    val uuid: String?,
    val watch_list_action: String?,
    val watermark: Boolean?
):Parcelable,ResponseObject<AttributeModel> {
    override fun toDomain(): AttributeModel {
        return AttributeModel(movie_title,movie_title_en,pic?.movie_img_s,cover,descr,rate_avrage)
    }
}