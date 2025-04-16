package com.example.framework.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ILibroGustadoDAO {

    @Query("SELECT * FROM libroGustado")
    fun getLibrosGustados(): List<LibroGustado>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(LibroGustado: LibroGustado)

    @Query("DELETE FROM LibroGustado")
    suspend fun deleteAll()
}