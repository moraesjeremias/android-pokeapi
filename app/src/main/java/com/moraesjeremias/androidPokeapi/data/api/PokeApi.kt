package com.moraesjeremias.androidPokeapi.data.api

import com.moraesjeremias.androidPokeapi.domain.Pokemon
import io.github.cdimascio.dotenv.dotenv
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope


class PokeApi {
    val httpClient = HttpClient(Android) {
        install(JsonFeature){
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json{
                prettyPrint = true
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }
//    val dotenv = dotenv {
//        directory = "./assets"
//        filename = "env"
//    }

    suspend fun getPokemon(id: Int) : Pokemon {
        val baseURL = "https://pokeapi.co"//dotenv.get("POKEAPI_BASE_URL")
        val url = URLBuilder(baseURL)
        url.path("/api/v2/pokemon/$id")
        return httpClient.get(url.build())
    }

    suspend fun getPokemonList(offset: Int, limit: Int = 9): List<Pokemon>{
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