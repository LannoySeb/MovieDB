package com.example.moviedb.Feature.Home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviedb.Api.Service.HomeService
import com.example.moviedb.Model.Movie
import kotlinx.coroutines.launch
import java.time.LocalDate
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    val homeService by inject<HomeService>()

    var moviesArray :  MutableLiveData<Array<Movie>> = MutableLiveData<Array<Movie>>()

    var query : MutableLiveData<String> = MutableLiveData<String>()

    fun search(query: String) {

        viewModelScope.launch {
            moviesArray.value = homeService.searchMovie(query)
        }

    }
}