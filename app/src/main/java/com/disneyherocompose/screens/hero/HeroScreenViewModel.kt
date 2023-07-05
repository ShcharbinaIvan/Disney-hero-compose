package com.disneyherocompose.screens.hero

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.disneyherocompose.database.model.Hero
import com.disneyherocompose.repository.HeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroScreenViewModel @Inject constructor(
    private val heroRepository: HeroRepository
) : ViewModel() {

    val hero = MutableLiveData<Hero>()

    fun getHero(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = heroRepository.getAllHeroesList()
            if (response.isSuccessful) {
                hero.postValue(response.body()?.data?.find { hero -> hero._id == id })
            }
        }
    }

}