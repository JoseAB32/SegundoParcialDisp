package com.example.framework.libros

import com.example.data.NetworkResult
import com.example.data.libro.ILibroRemoteDataSource
import com.example.domain.Libro
import com.example.framework.mappers.toModel
import com.example.framework.service.RetrofitBuilder

class LibroRemoteDataSource (
    val retrofitBuilder: RetrofitBuilder
): ILibroRemoteDataSource{
    override suspend fun fetch(titulo: String): NetworkResult<List<Libro>> {
        println("------------------------")
        val response = retrofitBuilder.apiService.getLibros(titulo)
        if(response.isSuccessful){
            return NetworkResult.Success(response.body()!!.results.map { it.toModel() })
        } else {
            return NetworkResult.Error(response.message())
        }
    }

}