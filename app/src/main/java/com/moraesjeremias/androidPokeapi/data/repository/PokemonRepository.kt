package com.moraesjeremias.androidPokeapi.data.repository

import com.moraesjeremias.androidPokeapi.data.api.PokeApiService

class PokemonRepository(
    private val pokeApiService: PokeApiService
) {
    suspend fun listPokemons(offset: Int)=
        pokeApiService.getPokemonList(offset)
}