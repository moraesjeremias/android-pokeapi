package com.moraesjeremias.androidPokeapi.data.api

import com.moraesjeremias.androidPokeapi.data.models.PokemonModel
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope


class PokeApiService(
    private val ktorClient: KtorClient
) {

    suspend fun getPokemon(id: Int) : PokemonModel {
        val baseURL = "https://pokeapi.co"//dotenv.get("POKEAPI_BASE_URL")
        val url = URLBuilder(baseURL)
        url.path("/api/v2/pokemon/$id")
        return ktorClient.httpClient.get(url.build())
    }

    suspend fun getPokemonList(offset: Int, limit: Int = 39): List<PokemonModel>{
        val pokemonIDList = offset..offset.plus(limit)
        val pokemonList = pokemonIDList.map { pokeId ->
            coroutineScope {
                async {
                    getPokemon(pokeId)
                }
            }
        }
        return pokemonList.awaitAll()
    }
}