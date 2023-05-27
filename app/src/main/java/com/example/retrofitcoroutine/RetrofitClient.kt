package com.example.retrofitcoroutine

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    fun getInstance(): Retrofit {

        val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient()
            .addInterceptor(httpLoggingInterceptor).build()

        return Retrofit.Builder().baseUrl("http://reqres.in")
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
            .build()
    }
}