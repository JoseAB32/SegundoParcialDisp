package com.example.framework.service

import com.example.framework.dto.LibroResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {
    @GET("search.json")
    suspend fun getLibros(@Query("q") titulo: String): Response<LibroResponseDto>
}
