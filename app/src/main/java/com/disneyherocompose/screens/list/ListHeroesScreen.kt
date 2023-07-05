package com.disneyherocompose.screens.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.disneyherocompose.R
import com.disneyherocompose.navigation.HERO_SCREEN
import com.disneyherocompose.ui.theme.AppBack


@Composable
fun ListHeroScreen(
    navHostController: NavHostController,
    viewModel: ListHeroesViewModel = hiltViewModel()
) {
    viewModel.getListHeroes()
    val listHeroes = viewModel.listHeroes.observeAsState()
    Box(
        modifier = Modifier
            .background(AppBack)
            .fillMaxSize()
    ) {
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .padding(top = 76.dp, start = 22.dp)
        ) {
            Text(text = stringResource(R.string.all), color = Color.White, fontSize = 18.sp)

        }
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .padding(top = 76.dp, start = 110.dp)
        ) {
            Text(text = stringResource(R.string.my), color = Color.White, fontSize = 18.sp)

        }
    }
    LazyColumn(
        modifier = Modifier.padding(
            top = 196.dp, start = 20.dp
        )
    ) {
        items(listHeroes.value ?: arrayListOf()) {
            Column(
                modifier = Modifier.selectable(
                    true,
                    onClick = { navHostController.navigate("$HERO_SCREEN/${it._id}") })
            ) {
                Row {
                    AsyncImage(
                        model = it.imageUrl,
                        contentDescription = "imageHero",
                        modifier = Modifier
                            .width(170.dp)
                            .height(150.dp)
                    )
                }
                Row {
                    Text(text = it.name, color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}