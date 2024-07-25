package com.example.moviedb.Api

import com.example.moviedb.Api.bindingModel.SearchMovieBindingModel
import com.example.moviedb.Model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbApi {

    @GET("authentication/guest_session/new")
    suspend fun CreateGuestSession() : Response<String>
    @GET("search/movie")
    suspend fun getSearchMovieAsync(@Query("query") query: String) : Response<SearchMovieBindingModel>
}