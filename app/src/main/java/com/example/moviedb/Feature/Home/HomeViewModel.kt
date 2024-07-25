package com.example.moviedb.Feature.Home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.Api.MovieDbApi
import com.example.moviedb.Api.interceptor.AuthInterceptor
import com.example.moviedb.Model.Movie
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import java.time.LocalDate
import java.util.Date

class HomeViewModel : ViewModel() {

    lateinit var service : MovieDbApi
    var moviesArray :  MutableLiveData<Array<Movie>> = MutableLiveData<Array<Movie>>()

    init {
        service = getRetrofit(getDefaultHttpClient()).create(MovieDbApi::class.java)
    }

    public fun search(query: String) {

        viewModelScope.launch {
//        var a = service.getSearchMovieAsync("spider");
            moviesArray.value = createMovieListStubs()
        }

    }

    fun createMovieListStubs(): Array<Movie> {
        return arrayOf(
            Movie(
                "The Shawshank Redemption",
                "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg",
                LocalDate.of(1994, 9, 23)
            ),
            Movie(
                "The Dark Knight",
                "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SX300.jpg",
                LocalDate.of(2008, 7, 18)
            ),
            Movie(
                "Pulp Fiction",
                "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
                LocalDate.of(1994, 10, 14)
            ),
            Movie(
                "Inception",
                "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg",
                LocalDate.of(2010, 7, 16)
            ),
            Movie(
                "The Matrix",
                "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg",
                LocalDate.of(1999, 3, 31)
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