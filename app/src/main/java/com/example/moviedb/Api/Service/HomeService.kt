package com.example.moviedb.Api.Service

import com.example.moviedb.Api.MovieDbApi
import com.example.moviedb.Model.Movie

class HomeService(private val movieApi : MovieDbApi) {
    suspend fun searchMovie(query : String) : Array<Movie>?{
        val response = movieApi.getSearchMovieAsync(query)
        return response.body()
    }
}