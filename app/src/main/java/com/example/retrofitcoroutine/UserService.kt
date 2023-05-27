package com.example.retrofitcoroutine

import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("/api/user?page=2")
    suspend fun getAllUsers(): Response<User>
}