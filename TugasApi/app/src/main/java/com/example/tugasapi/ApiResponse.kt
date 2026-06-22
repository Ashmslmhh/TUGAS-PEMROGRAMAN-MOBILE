package com.example.tugasapi

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val message: String,
    val code: String,
    val data: List<Unggas>
)

@Serializable
data class Unggas(
    val id: Int,
    val nama: String,
    val jenis: String,
    val jumlahKaki: Int
)