package com.moraesjeremias.androidPokeapi.data.api

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class KtorClient {
    val httpClient = HttpClient(Android) {
        install(JsonFeature){
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json{
                prettyPrint = true
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
    }

}