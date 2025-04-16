package com.example.framework.libros

import android.content.Context
import com.example.data.libro.ILibroLocalDataSource
import com.example.domain.Libro
import com.example.framework.mappers.toEntity
import com.example.framework.mappers.toModel
import com.example.framework.persistence.AppRoomDatabase
import com.example.framework.persistence.ILibroGustadoDAO
import com.example.framework.persistence.LibroGustado

class LibroLocalDataSource(val context: Context) : ILibroLocalDataSource {
    val libroDAO:ILibroGustadoDAO =AppRoomDatabase.getDatabase(context).LibroDao()
    override suspend fun save(libro: Libro): Boolean {
        libroDAO.insert(libro.toEntity())
        return true
    }

    override suspend fun listar(): List<Libro> {
        return  libroDAO.getLibrosGustados().map { it.toModel() }
    }


}