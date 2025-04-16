package com.example.framework.service

import com.example.framework.dto.LibroResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {
    @GET("/search.json")
    //@Query("q") titulo: String
    suspend fun getLibros(@Query("q") title: String): Response<LibroResponseDto>
}
