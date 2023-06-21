package com.disneyherocompose.database.network

import com.disneyherocompose.database.model.AllHeroesResponse
import retrofit2.Response
import retrofit2.http.GET

interface DisneyHeroApi {

    @GET("/character")
    suspend fun getListHeroes(): Response<AllHeroesResponse>
}