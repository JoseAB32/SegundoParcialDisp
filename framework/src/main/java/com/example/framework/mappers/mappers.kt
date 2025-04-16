package com.example.framework.mappers

import com.example.domain.Libro
import com.example.framework.dto.LibroDto
import com.example.framework.persistence.LibroGustado

fun LibroDto.toModel(): Libro{
    return Libro(
        titulo = title,
        autores = autores,
        anio = anio,
        MeGusta = false
    )
}

fun Libro.toEntity(): LibroGustado{
    return LibroGustado(titulo, autores, anio)
}

fun LibroGustado.toModel() :Libro{
    return Libro(
        titulo = titulo,
        autores = autores,
        anio = anio,
        MeGusta = true
    )

}