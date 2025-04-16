package com.example.segundoparcial.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        //Inicializae Firebase
    }
}