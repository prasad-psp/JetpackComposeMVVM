package com.example.jetpackcomposemvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposemvvm.data.repo.TweetsyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val tweetsyRepo: TweetsyRepo): ViewModel() {

    val category: StateFlow<List<String>>
        get() = tweetsyRepo.category

    init {
        viewModelScope.launch {
            tweetsyRepo.getCategory()
        }
    }


}