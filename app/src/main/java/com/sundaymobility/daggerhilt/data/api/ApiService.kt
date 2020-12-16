package com.sundaymobility.daggerhilt.data.api


import com.sundaymobility.daggerhilt.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService  {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}