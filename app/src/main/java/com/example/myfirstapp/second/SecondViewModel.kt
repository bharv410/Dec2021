package com.example.myfirstapp.second

import androidx.lifecycle.*
import com.example.myfirstapp.api.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class SecondViewModel(private val repository: Repository) : ViewModel() {

    private var _responseLiveData : MutableLiveData<Response> = MutableLiveData()
    val response : LiveData<Response> = _responseLiveData

    fun fetchGoogle(){

        viewModelScope.launch (Dispatchers.IO) {
            _responseLiveData.postValue(repository.getSearchResults())
        }
    }
}