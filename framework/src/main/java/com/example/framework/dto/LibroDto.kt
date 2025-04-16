package com.example.framework.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class LibroDto (
    @Json(name = "autores")
    val autores: List<String>,
    @Json(name = "titulo")
    val title: String,
    @Json(name = "anio")
    val anio: Int?
){
}