package com.example.moviedb.Feature.Home

import androidx.lifecycle.ViewModel
import com.example.moviedb.Api.MovieDbApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeViewModel : ViewModel() {

    lateinit var service : MovieDbApi

    init {
        service = getRetrofit(getDefaultHttpClient()).create(MovieDbApi::class.java)
    }

    public suspend fun search(){
        var a = service.getSearchMovieAsync("spider");
        println(a.size)
    }
    fun getDefaultHttpClient(): OkHttpClient {
        // TODO Add interceptor
        return OkHttpClient.Builder()
            .build()
    }
    fun getRetrofit(client: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}