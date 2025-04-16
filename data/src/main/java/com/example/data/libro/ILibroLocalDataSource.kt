package com.example.data.libro

import com.example.domain.Libro

interface ILibroLocalDataSource {
    suspend fun save(libro: Libro): Boolean
    suspend fun listar(): List<Libro>
}