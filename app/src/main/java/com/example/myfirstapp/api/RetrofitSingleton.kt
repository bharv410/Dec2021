package com.example.myfirstapp.api

import com.example.myfirstapp.api.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val simpleApi: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java )
    }
}