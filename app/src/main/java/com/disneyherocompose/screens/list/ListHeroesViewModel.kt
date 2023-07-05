package com.disneyherocompose.screens.list


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
class ListHeroesViewModel @Inject constructor(
    private val heroRepository: HeroRepository
) : ViewModel() {

    val listHeroes = MutableLiveData<ArrayList<Hero>>()

    fun getListHeroes() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = heroRepository.getAllHeroesList()
            if (response.isSuccessful) {
                listHeroes.postValue(response.body()?.data)
            }
        }
    }

}