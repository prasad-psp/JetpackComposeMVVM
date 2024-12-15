package com.example.jetpackcomposemvvm.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposemvvm.data.repo.TweetsyRepo
import com.example.jetpackcomposemvvm.model.TweetsyListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val tweetsyRepo: TweetsyRepo,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val tweetsy: StateFlow<List<TweetsyListItem>>
        get() = tweetsyRepo.tweetsy

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "Android"
            tweetsyRepo.getTweetsy(category)
        }
    }


}