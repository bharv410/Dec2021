package com.example.myfirstapp.second

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstapp.api.repository.Repository

class SecondViewModelFactory(val repo: Repository)  : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SecondViewModel::class.java)) {
            return SecondViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}