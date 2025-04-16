package com.example.domain

import kotlinx.serialization.Serializable

@Serializable
data class Libro(
    val titulo: String,
    val autores: List<String>,
    val anio: Int,
    val MeGusta: Boolean
) {
}