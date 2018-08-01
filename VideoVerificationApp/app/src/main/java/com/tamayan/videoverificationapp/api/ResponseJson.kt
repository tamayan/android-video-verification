package com.tamayan.videoverificationapp.api

import com.squareup.moshi.Json

data class ResponseJson(
        @Json(name = "items") val item: List<Item>)

data class Item(
        val id: String,
        @Json(name = "contentDetails") val contentDetail: ContentDetail)

data class ContentDetail(
        val duration: String)