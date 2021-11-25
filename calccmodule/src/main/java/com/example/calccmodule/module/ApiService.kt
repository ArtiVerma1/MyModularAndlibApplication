package com.example.calccmodule.module


import com.example.calccmodule.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/users?page=1")
    suspend fun getUsers(): Response<UserModel>
}