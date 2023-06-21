package com.disneyherocompose.repository

import com.disneyherocompose.database.network.DisneyHeroApi
import javax.inject.Inject

class HeroRepository @Inject constructor(
    private val disneyHeroApi: DisneyHeroApi
) {

    suspend fun getAllHeroesList() = disneyHeroApi.getListHeroes()

}