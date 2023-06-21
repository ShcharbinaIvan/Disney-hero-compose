package com.disneyherocompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ListHeroScreen(
    viewModel: ListHeroesViewModel = hiltViewModel()
) {
    viewModel.getListHeroes()
    val listHeroes = viewModel.listHeroes.observeAsState()
    LazyColumn {
        items(listHeroes.value ?: arrayListOf()) {
            Column {
                Row {
                    Text(text = it.name)
                }
            }
        }
    }
}