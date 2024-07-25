package com.example.moviedb.Feature.Home

import androidx.lifecycle.ViewModel
import com.example.moviedb.Api.MovieDbApi
import com.example.moviedb.Api.interceptor.AuthInterceptor
import com.example.moviedb.Model.Movie
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Date

class HomeViewModel : ViewModel() {

    lateinit var service : MovieDbApi

    init {
        service = getRetrofit(getDefaultHttpClient()).create(MovieDbApi::class.java)
    }

    public suspend fun search(){
//        var a = service.getSearchMovieAsync("spider");
//        println(a.size)
    }

    fun createMovieListStubs(): Array<Movie> {
        return arrayOf(
            Movie(
                "The Shawshank Redemption",
                "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg",
                Date(7776000000) // September 23, 1994
            ),
            Movie(
                "The Dark Knight",
                "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg",
                Date(1214803200000) // July 18, 2008
            ),
            Movie(
                "Pulp Fiction",
                "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
                Date(769728000000) // October 14, 1994
            ),
            Movie(
                "Inception",
                "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg",
                Date(1278422400000) // July 16, 2010
            ),
            Movie(
                "The Matrix",
                "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg",
                Date(922848000000) // March 31, 1999
            )
        )
    }

    fun getDefaultHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
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