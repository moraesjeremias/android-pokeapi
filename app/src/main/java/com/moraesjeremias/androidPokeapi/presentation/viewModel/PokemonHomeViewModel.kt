package com.moraesjeremias.androidPokeapi.presentation.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moraesjeremias.androidPokeapi.data.repository.PokemonRepository
import com.moraesjeremias.androidPokeapi.domain.Pokemon
import com.moraesjeremias.androidPokeapi.domain.transformModelToDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class PokemonHomeViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val _pokemonListState: MutableState<MutableList<Pokemon>> = mutableStateOf(mutableListOf())//MutableStateFlow(mutableListOf<Pokemon>())
    val pokemonListState: MutableState<MutableList<Pokemon>> = _pokemonListState
    private val _offsetState = MutableStateFlow(1)
    val offsetState: StateFlow<Int> = _offsetState.asStateFlow()
    private val _oldOffsetState = MutableStateFlow(1)
    val oldOffsetState: StateFlow<Int> = _oldOffsetState.asStateFlow()


    init {
        viewModelScope.launch {
            getPokemons(offsetState.value)
        }
    }

        suspend fun getPokemons(offset: Int) {
                val pokemonModelList = pokemonRepository.listPokemons(offset)
                val pokemonList = pokemonModelList.map { pokemonModel ->
                    transformModelToDomain(pokemonModel)
                }
                _pokemonListState.value.addAll(pokemonList)
                _offsetState.value = pokemonList.last().id.toInt().plus(1)
                print("This is offseState: ${offsetState.value}")
            }

}