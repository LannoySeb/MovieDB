package com.example.moviedb.Api.interceptor

import com.example.moviedb.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

            val original = chain.request()
            val originalUrl = original.url()
            val url = originalUrl.newBuilder()
                .build()
            val requestBuilder =
                original.newBuilder().url(url)
                    .addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")


            val request = requestBuilder.build()

            return chain.proceed(request)
    }
}