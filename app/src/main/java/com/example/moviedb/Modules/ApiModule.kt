package com.example.moviedb.Modules

import com.example.moviedb.Api.MovieDbApi
import com.example.moviedb.Api.client.AppHttpClientFactory
import com.example.moviedb.Api.configuration.ConfigurationService
import com.example.moviedb.Api.interceptor.AuthInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.create

val ApiModules = module {
    scope(named<ConfigurationService>()) {
        factory { AppHttpClientFactory(this) }
        scoped { get<AppHttpClientFactory>().getRetrofit().create<MovieDbApi>() }
    }

    factory<AuthInterceptor>(named<AuthInterceptor>()){
        AuthInterceptor()
    }
}