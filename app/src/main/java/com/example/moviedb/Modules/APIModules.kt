package com.example.moviedb.Modules

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//val apiModules = module {
//    single<OkHttpClient>(){ getDefaultHttpClient() }
//    single<Retrofit>(){ getRetrofit(get()) }
//}
//
//fun getDefaultHttpClient(): OkHttpClient{
//    // TODO Add interceptor
//    return OkHttpClient.Builder()
//        .build()
//}
//fun getRetrofit(client: OkHttpClient) : Retrofit{
//    return Retrofit.Builder()
//        .baseUrl("https://api.themoviedb.org/3/")
//        .client(client)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//}