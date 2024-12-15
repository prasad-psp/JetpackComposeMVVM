package com.example.jetpackcomposemvvm.data.repo

import com.example.jetpackcomposemvvm.data.api.TweetsyApi
import com.example.jetpackcomposemvvm.model.TweetsyListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsyRepo @Inject constructor(private val tweetsyApi: TweetsyApi) {


    private val _category = MutableStateFlow<List<String>>(emptyList())
    val category: StateFlow<List<String>>
        get() = _category

    private val _tweetsy = MutableStateFlow<List<TweetsyListItem>>(emptyList())
    val tweetsy: StateFlow<List<TweetsyListItem>>
        get() = _tweetsy


    suspend fun getCategory() {
        val resp = tweetsyApi.getCategoryList()
        if (resp.isSuccessful && resp.body() != null) {
            _category.emit(resp.body()!!)
        }
    }

    suspend fun getTweetsy(category: String) {
        val resp = tweetsyApi.getTweetsyList("tweets[?(@.category==\"$category\")]")
        if (resp.isSuccessful && resp.body() != null) {
            _tweetsy.emit(resp.body()!!)
        }
    }
}