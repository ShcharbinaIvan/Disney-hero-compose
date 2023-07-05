package com.disneyherocompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.disneyherocompose.screens.hero.HeroScreen
import com.disneyherocompose.screens.list.ListHeroScreen
import com.disneyherocompose.screens.preview.PreviewScreen

const val PREVIEW_SCREEN = "previewScreen"
const val LIST_HERO_SCREEN = "listHeroScreen"
const val HERO_SCREEN = "herScreen"

@Composable
fun MyNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = PREVIEW_SCREEN
    ) {
        composable(PREVIEW_SCREEN) {
            PreviewScreen(navController)
        }
        composable(LIST_HERO_SCREEN) {
            ListHeroScreen(navController)
        }
        composable(
            "$HERO_SCREEN/{heroId}",
            arguments = listOf(navArgument("heroId") { type = NavType.IntType })
        ) {
            it.arguments?.let { it1 -> HeroScreen(it1.getInt("heroId")) }
        }

    }

}