package com.example.something.data.repositories

import com.example.something.data.api.UserApi
import jakarta.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserApi
) {
    suspend fun getUsers() = api.getUsers()
}