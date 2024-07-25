package com.example.moviedb.Api.bindingModel

import com.google.gson.annotations.SerializedName

data class SearchMovieBindingModel(
    @SerializedName("results")
    var movies:List<MovieBindingModel>
)
