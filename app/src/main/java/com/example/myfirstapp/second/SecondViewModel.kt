package com.example.myfirstapp.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class SecondViewModel : ViewModel() {

    private var _responseLiveData : MutableLiveData<String> = MutableLiveData("")


    fun fetchGoogle(term : String){
        viewModelScope.launch (Dispatchers.IO) {
            val client = OkHttpClient()

            var url = "https://google-search3.p.rapidapi.com/api/v1/search/q=" + term + "&num=50"
            val request = Request.Builder()
                .url(url)
                .get()
                .addHeader("x-user-agent", "desktop")
                .addHeader("x-proxy-location", "US")
                .addHeader("x-rapidapi-host", "google-search3.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "7d46b461dfmsh6e22844b5beb80ep1789f9jsn05189fc8fe2a")
                .build()

            val response = client.newCall(request).execute()

            _responseLiveData.postValue(response.body?.string())
        }
    }

    fun getResponse(): MutableLiveData<String>{
        return _responseLiveData
    }
}