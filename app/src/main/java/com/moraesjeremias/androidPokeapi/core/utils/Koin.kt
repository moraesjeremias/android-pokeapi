package com.moraesjeremias.androidPokeapi.core.utils

import com.moraesjeremias.androidPokeapi.data.api.KtorClient
import com.moraesjeremias.androidPokeapi.data.api.PokeApi
import org.koin.dsl.module
import org.koin.experimental.builder.single

val koinModule = module {
    single<KtorClient>()
    single<PokeApi>()
}