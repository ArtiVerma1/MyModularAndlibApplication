package com.example.calccmodule.module

import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiService) {

    suspend fun getUsers() =  apiHelper.getUsers()
}