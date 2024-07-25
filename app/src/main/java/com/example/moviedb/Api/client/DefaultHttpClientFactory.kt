package com.example.moviedb.Api.client

import com.example.moviedb.Api.configuration.IApplicationConfiguration
import com.example.moviedb.Api.interceptor.AuthInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.core.scope.Scope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class DefaultHttpClientFactory (open val scope: Scope){
    internal open fun getHttpClient(scope: Scope): OkHttpClient{
        throw NotImplementedError("This methode must be implemented")
    }

    internal fun getRetrofit():Retrofit{
        return getDefaultRetrofitBuilder(scope)
            .client(getHttpClient(scope))
            .build()
    }

    internal fun getDefaultHttpClientBuilder(scope: Scope): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()

        builder.addInterceptor(AuthInterceptor())

        return builder
    }

    private fun getDefaultRetrofitBuilder(scope: Scope): Retrofit.Builder {
        val appConfig = scope.get<IApplicationConfiguration>()
        return Retrofit.Builder()
            .baseUrl(appConfig.apiBaseUrl())
            .addConverterFactory(GsonConverterFactory.create(scope.get()))
    }
}