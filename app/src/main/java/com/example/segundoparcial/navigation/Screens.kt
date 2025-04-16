package com.example.segundoparcial.navigation

sealed class Screens (val route: String) {
    object BuscadorScreen : Screens("buscador")
    object LibroGustadosUI : Screens("libroGustados")
}