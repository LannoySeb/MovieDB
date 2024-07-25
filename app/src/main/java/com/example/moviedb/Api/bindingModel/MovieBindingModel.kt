package com.example.moviedb.Api.bindingModel

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

class MovieBindingModel(
    @SerializedName("original_title")
    val originalTitle : String,
    @SerializedName("poster_path")
    val posterUri : String?,
    @SerializedName("release_date")
    val releaseDate: String?
) {
}