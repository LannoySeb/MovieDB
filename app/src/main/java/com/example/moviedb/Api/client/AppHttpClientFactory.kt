package com.example.moviedb.Api.client

import okhttp3.OkHttpClient
import org.koin.core.scope.Scope
import java.util.concurrent.TimeUnit

class AppHttpClientFactory(override val scope: Scope) : DefaultHttpClientFactory(scope) {
    override fun getHttpClient(scope: Scope): OkHttpClient {
        val builder = getDefaultHttpClientBuilder(scope)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
        return builder.build()
    }
}