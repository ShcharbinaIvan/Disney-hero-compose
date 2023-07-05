package com.disneyherocompose.database.model

data class Hero(
    val _id: Int,
    val films: List<String>,
    val shortFilms: List<String>,
    val tvShows: List<String>,
    val videoGames: List<String>,
    val parkAttractions: List<String>,
    val name: String,
    val imageUrl: String,
    val url: String
)
