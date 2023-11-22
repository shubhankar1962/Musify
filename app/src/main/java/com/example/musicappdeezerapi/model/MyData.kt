package com.example.musicappdeezerapi.model

data class MyData(
    val `data`: List<Data>,
    val next: String,
    val total: Int
)