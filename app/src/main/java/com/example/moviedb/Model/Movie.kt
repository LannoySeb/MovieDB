package com.example.moviedb.Model

import java.time.LocalDate


data class Movie(
    val originalTitle : String,
    val posterUri : String,
    val releaseDate: LocalDate

)
