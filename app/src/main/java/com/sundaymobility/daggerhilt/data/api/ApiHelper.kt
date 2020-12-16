package com.sundaymobility.daggerhilt.data.api

import com.sundaymobility.daggerhilt.data.model.User
import retrofit2.Response


interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>

}