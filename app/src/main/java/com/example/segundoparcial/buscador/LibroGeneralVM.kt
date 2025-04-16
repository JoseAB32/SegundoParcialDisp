package com.example.segundoparcial.buscador

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Libro
import com.example.data.NetworkResult
import com.example.usecases.GetLibros
import com.example.usecases.GetLibrosBD
import com.example.usecases.SaveLibro
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LibroGenViewModel @Inject constructor(
    private val buscar: GetLibros,
    private val GetLibrosBD: GetLibrosBD,
    private val GuardarLibro: SaveLibro,
    @ApplicationContext private val context: Context
): ViewModel() {
    sealed class BookState {
        object init: BookState()
        data class SuccessList(val model: List<Libro>): BookState()
        data class SuccessLike(val message: String): BookState()
        data class Error(val message: String): BookState()
    }
    private val _state = MutableStateFlow<BookState>(BookState.init)
    val state : StateFlow<BookState> = _state

    private val _libros = MutableStateFlow<List<Libro>>(emptyList())
    val libros: StateFlow<List<Libro>> = _libros

    private val _likeMessage = MutableStateFlow<String?>(null)
    val likeMessage: StateFlow<String?> = _likeMessage

    private val _librosLike = MutableStateFlow<List<Libro>>(emptyList())
    val librosLike: StateFlow<List<Libro>> = _librosLike

    fun buscarLibros(titulo: String) {
        _state.value = BookState.init
        viewModelScope.launch {
            val response = buscar.invoke(titulo)
            when ( val result = response ) {
                is NetworkResult.Error -> {
                    _state.value = BookState.Error(result.error)
                }
                is NetworkResult.Success<List<Libro>> -> {
//                    _state.value = BookState.SuccessList(result.data)
                    _libros.value = result.data
                }
            }
        }
    }

    fun clearMessage() {
        _state.value = BookState.init
    }

    fun GuardarLibro(book: Libro) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    GuardarLibro.invoke(book)
                    _likeMessage.value = "Se añadió el libro ${book.titulo} a tus guardados"
                }
            } catch (e: Exception) {
                _likeMessage.value = "Error al dar like: ${e.message}"
            }
        }
    }

    fun getLibros() {
        viewModelScope.launch() {
            try {
                withContext(Dispatchers.IO) {
                    val libros = GetLibrosBD.invoke()
                    _libros.value = libros
                    _state.value = BookState.init
                }
            } catch (e: Exception) {
                _state.value = BookState.Error("Error al mostrar los libros guardados ${e.message}")
            }
        }
    }


}