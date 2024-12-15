package com.example.jetpackcomposemvvm.data.api

import com.example.jetpackcomposemvvm.model.TweetsyListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {

    @GET("/v3/b/675d6284acd3cb34a8b97d15?meta=false")
    suspend fun getTweetsyList(@Header("X-JSON-Path") category: String) : Response<List<TweetsyListItem>>

    @GET("/v3/b/675d6284acd3cb34a8b97d15?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategoryList() : Response<List<String>>
}