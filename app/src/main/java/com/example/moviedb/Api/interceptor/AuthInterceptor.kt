package com.example.moviedb.Api.interceptor

import android.content.res.Resources
import com.example.moviedb.BuildConfig
import com.example.moviedb.R
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        var urlString = chain.request().url().toString()
//        if(!urlString.contains("/authentication")||!urlString.contains("/newAccount")) {
            val original = chain.request()
            val originalUrl = original.url()
            val url = originalUrl.newBuilder()
                .build()
            val requestBuilder =
                original.newBuilder().url(url)
                    .addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")


            val request = requestBuilder.build()

            return chain.proceed(request)
//        }
//        return chain.proceed(chain.request())
    }
}