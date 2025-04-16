package com.example.usecases

import com.example.data.LibroRepository
import com.example.domain.Libro

class SaveLibro(
    val libroRepository: LibroRepository
)
{
    suspend fun invoke(libro: Libro) {
        libroRepository.save(libro)
    }
}