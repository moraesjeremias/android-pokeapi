package com.moraesjeremias.androidPokeapi.core.utils.di

import com.moraesjeremias.androidPokeapi.data.api.KtorClient
import com.moraesjeremias.androidPokeapi.data.api.PokeApiService
import com.moraesjeremias.androidPokeapi.data.repository.PokemonRepository
import com.moraesjeremias.androidPokeapi.presentation.viewModel.PokemonHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.experimental.builder.single

val koinModule = module {
    single<KtorClient>()
    single<PokeApiService>()
    single<PokemonRepository>()
}

val viewModelKoinModule = module {
    viewModel{ PokemonHomeViewModel(get()) }
}