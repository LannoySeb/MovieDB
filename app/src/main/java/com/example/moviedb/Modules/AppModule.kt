package com.example.moviedb.Modules

import com.example.moviedb.Api.configuration.ConfigurationService
import com.example.moviedb.Api.configuration.DevApplicationConfiguration
import com.example.moviedb.Api.configuration.IApplicationConfiguration
import com.google.gson.GsonBuilder
import org.koin.dsl.module

val AppModule = module {
    factory<IApplicationConfiguration>{DevApplicationConfiguration()}
    single { ConfigurationService().apply { addOrChangeConfiguration(get()) } }

    single{
        GsonBuilder()
            .setLenient()
            .create()
    }
}