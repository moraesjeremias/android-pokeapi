package com.moraesjeremias.androidPokeapi.data.repository

import com.moraesjeremias.androidPokeapi.data.api.PokeApi

class PokemonRepository(
    private val pokeApi: PokeApi
) {
    suspend fun listPokemons(offset: Int)=
        pokeApi.getPokemonList(offset)
}