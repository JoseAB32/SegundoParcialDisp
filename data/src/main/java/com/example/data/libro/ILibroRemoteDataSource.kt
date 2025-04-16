package com.example.data.libro

import com.example.data.NetworkResult
import com.example.domain.Libro

interface ILibroRemoteDataSource {
    suspend fun fetch(titulo: String): NetworkResult<List<Libro>>
}