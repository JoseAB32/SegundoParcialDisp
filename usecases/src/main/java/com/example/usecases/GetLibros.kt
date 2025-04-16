package com.example.usecases

import com.example.data.LibroRepository
import com.example.data.NetworkResult
import com.example.domain.Libro


class GetLibros (
    val libroRepository: LibroRepository

){
    suspend fun invoke(titulo: String): NetworkResult<List<Libro>> {
        return this.libroRepository.finbyTitle(titulo)
    }
}