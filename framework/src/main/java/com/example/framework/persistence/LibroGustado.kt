package com.example.framework.persistence


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class LibroGustado(
    @ColumnInfo(name = "titulo")
    var titulo: String,
    @ColumnInfo(name = "titulo")
    var autores: List<String>,
    @ColumnInfo(name = "titulo")
    var anio: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

    @RequiresApi(Build.VERSION_CODES.O)
    @ColumnInfo(name = "create_at")
    var createAt: String = LocalDateTime.now().toString()
}