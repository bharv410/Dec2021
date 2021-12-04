package com.example.myfirstapp.api.repository

import com.example.myfirstapp.api.RetrofitSingleton
import com.example.myfirstapp.second.Response

class Repository {

    suspend fun getSearchResults() : Response {
        return RetrofitSingleton.simpleApi.getSearchResults()
    }
}