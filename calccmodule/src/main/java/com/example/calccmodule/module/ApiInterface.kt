package com.example.calccmodule.module

import com.example.calccmodule.model.UserModel
import retrofit2.Response

interface ApiInterface {
    suspend fun getUsers(): Response<UserModel>
}