package com.example.latihanrecyclerview.model

data class Item(
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int,
    var isActive: Boolean = false
)