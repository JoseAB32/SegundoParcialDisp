package com.example.usecases

import com.example.data.LibroRepository
import com.example.domain.Libro

class GetLibrosBD (
    val libroRepository: LibroRepository
){
    suspend fun invoke(): List<Libro>{
        return libroRepository.listar()
    }
}