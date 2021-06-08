package com.koko.manga.model

import com.squareup.moshi.Json

data class FootballModel(@Json(name = "title") val title: String,
                         @Json(name = "date") val date: String)

