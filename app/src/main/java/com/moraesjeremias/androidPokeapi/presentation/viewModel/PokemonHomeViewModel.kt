package com.moraesjeremias.androidPokeapi.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.moraesjeremias.androidPokeapi.data.repository.PokemonRepository
import com.moraesjeremias.androidPokeapi.domain.transformModelToDomain


class PokemonHomeViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {
        suspend fun getPokemons(offset: Int) =
            with(offset){
                val pokemonModelList = pokemonRepository.listPokemons(this)
                pokemonModelList.map { pokemonModel ->
                    transformModelToDomain(pokemonModel)
                }
            }

}