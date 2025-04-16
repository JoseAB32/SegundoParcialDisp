package com.example.data

import com.example.data.libro.ILibroLocalDataSource
import com.example.data.libro.ILibroRemoteDataSource
import com.example.domain.Libro

class LibroRepository (private val remoteDataSource: ILibroRemoteDataSource,
                       private val localDataSource: ILibroLocalDataSource){
    suspend fun finbyTitle(title: String):NetworkResult<List<Libro>>{
        return this.remoteDataSource.fetch(title)
    }

    suspend fun save(Libro: Libro): Boolean{
        this.localDataSource.save(Libro)
        return true
    }

    suspend fun listar(): List<Libro>{
        return this.localDataSource.listar()
    }

}