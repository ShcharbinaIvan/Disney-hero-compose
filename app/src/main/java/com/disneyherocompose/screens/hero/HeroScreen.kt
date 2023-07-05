package com.disneyherocompose.screens.hero

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage


@Composable
fun HeroScreen(
    id: Int,
    viewModel: HeroScreenViewModel = hiltViewModel()
) {

    viewModel.getHero(id)
    val hero = viewModel.hero.observeAsState()

    Row {
        AsyncImage(
            model = hero.value?.imageUrl,
            contentDescription = "imageHero",
            modifier = Modifier
                .width(170.dp)
                .height(150.dp)
        )
    }
    Row {
        hero.value?.let { Text(text = it.name, color = Color.Black, fontSize = 18.sp) }
    }

}