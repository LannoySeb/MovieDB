package com.example.moviedb.Api.configuration

import java.net.URL

interface IApplicationConfiguration {
    var baseUrl: URL

    fun apiBaseUrl() : String
}

class DevApplicationConfiguration(
    override var baseUrl: URL = URL("https://api.themoviedb.org/3/")
): IApplicationConfiguration{
    override fun apiBaseUrl(): String {
        return baseUrl.toString()
    }
    }
