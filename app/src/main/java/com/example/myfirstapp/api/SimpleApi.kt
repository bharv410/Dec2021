package com.example.myfirstapp.api

import com.example.myfirstapp.second.Response
import com.example.myfirstapp.second.SearchResult
import retrofit2.http.GET
import retrofit2.http.Headers

interface SimpleApi {

    @Headers(
        "x-user-agent: desktop",
        "x-proxy-location: US",
        "x-rapidapi-host: google-search3.p.rapidapi.com",
        "x-rapidapi-key: 7d46b461dfmsh6e22844b5beb80ep1789f9jsn05189fc8fe2a"
    )
    @GET("search/q=elon+musk&num=50")
    suspend fun getSearchResults() : Response
}