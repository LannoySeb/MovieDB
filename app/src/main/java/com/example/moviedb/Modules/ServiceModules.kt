package com.example.moviedb.Modules

import com.example.moviedb.Api.Service.HomeService
import com.example.moviedb.Api.configuration.ConfigurationService
import org.koin.core.qualifier.named
import org.koin.dsl.module

val ServiceModules = module {
    factory { HomeService(getScope("${named<ConfigurationService>()}").get()) }
}