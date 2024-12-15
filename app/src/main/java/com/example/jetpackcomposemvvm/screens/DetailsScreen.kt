package com.example.jetpackcomposemvvm.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposemvvm.viewmodel.DetailsViewModel


@Composable
fun DetailsScreen() {
    val detailsViewModel: DetailsViewModel = viewModel()
    val tweetsy = detailsViewModel.tweetsy.collectAsState()

    LazyColumn(content = {
        items(tweetsy.value) {
            TweetsyListItem(it.text)
        }
    })
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