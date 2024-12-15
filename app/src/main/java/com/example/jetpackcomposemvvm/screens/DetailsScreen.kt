package com.example.jetpackcomposemvvm.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcomposemvvm.viewmodel.DetailsViewModel


@Composable
fun DetailsScreen() {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val tweetsy = detailsViewModel.tweetsy.collectAsState()

    if (tweetsy.value.isEmpty()) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(content = {
            items(tweetsy.value) {
                TweetsyListItem(it.text)
            }
        })
    }

}

@Composable
fun TweetsyListItem(tweetsy: String) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.error),

    ) {
        Text(
            tweetsy,
            modifier = Modifier
                .padding(16.dp),
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleSmall,
        )
    }
}