package com.example.framework.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LibroResponseDto (
    @Json(name = "results")
    val results: List<LibroDto>,
){
}