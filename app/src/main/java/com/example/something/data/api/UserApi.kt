package com.example.something.data.api

import com.example.something.data.models.User
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<User>
}