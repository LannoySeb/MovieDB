package com.example.moviedb.Api.Service

import com.example.moviedb.Api.MovieDbApi
import com.example.moviedb.Model.Movie
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeService(private val movieApi : MovieDbApi) {

    suspend fun searchMovie(query : String) : Array<Movie>?{
        val response = movieApi.getSearchMovieAsync(query)
        if(response.isSuccessful) {
            return response.body()?.movies?.map {
                var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                var date = if(it.releaseDate?.isEmpty() == false)LocalDate.parse(it.releaseDate, formatter) else null
                Movie(it.originalTitle, "https://image.tmdb.org/t/p/w185/${it.posterUri}", date)
            }?.toTypedArray()
        }
        else{
            return emptyArray();
        }
    }
}