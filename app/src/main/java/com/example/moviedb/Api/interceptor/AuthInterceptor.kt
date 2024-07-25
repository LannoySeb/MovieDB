package com.example.moviedb.Api.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val original: Request = chain.request()


        // Request customization: add request headers
        val requestBuilder: Request.Builder = original.newBuilder()
            .addHeader("accept", "application/json")
            .addHeader(
                "Authorization",
                "Bearer ${getToken()}"
            )

        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }

    private fun getToken(){
        // todo get token for Authorization
    }
}