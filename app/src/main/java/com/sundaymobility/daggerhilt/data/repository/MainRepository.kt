package com.sundaymobility.daggerhilt.data.repository

import com.sundaymobility.daggerhilt.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper){
    suspend fun getUser() = apiHelper.getUsers()
}

