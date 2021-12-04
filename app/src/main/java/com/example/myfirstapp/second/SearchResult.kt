package com.example.myfirstapp.second

data class SearchResult(
    val title: String,
    val link: String
) {
}

data class Response(
    val results: List<SearchResult>,
    val total: Int,
    val device_type: String
){
}