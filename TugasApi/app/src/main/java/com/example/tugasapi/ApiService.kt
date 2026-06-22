package com.example.tugasapi

import retrofit2.http.GET

interface ApiService {
    @GET(".")
    suspend fun getUnggas(): ApiResponse
}