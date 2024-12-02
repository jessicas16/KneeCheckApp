package com.example.kneecheck.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BasicDRO(
    var status : String,
    var message: String,
    var data: Any?
)