package com.moraesjeremias.androidPokeapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.moraesjeremias.androidPokeapi.R
import com.moraesjeremias.androidPokeapi.core.utils.di.koinModule
import com.moraesjeremias.androidPokeapi.core.utils.di.viewModelKoinModule
import com.moraesjeremias.androidPokeapi.data.repository.PokemonRepository
import com.moraesjeremias.androidPokeapi.domain.Pokemon
import com.moraesjeremias.androidPokeapi.presentation.pages.PokemonHomeScreen
import com.moraesjeremias.androidPokeapi.presentation.viewModel.PokemonHomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject
import org.koin.core.context.startKoin


class MainActivity : AppCompatActivity() {
    private val repository by inject<PokemonRepository>()
    private val pokemonHomeViewModel by inject<PokemonHomeViewModel>()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_PokeApiSplashScreen)
        Thread.sleep(1000)
        setTheme(R.style.Theme_AndroidPokeApi)

        super.onCreate(savedInstanceState)
        startKoin {
            modules(listOf(koinModule, viewModelKoinModule))
        }
        lateinit var pokemons: List<Pokemon>
        runBlocking {
            pokemonHomeViewModel.getPokemons(pokemonHomeViewModel.offsetState.value)
        }
        setContent {
            PokemonHomeScreen(pokemonHomeViewModel)
        }


    }

    override fun onResume() {
        super.onResume()
        if (pokemonHomeViewModel.offsetState.value == 11){
            runBlocking {
                pokemonHomeViewModel.getPokemons(pokemonHomeViewModel.offsetState.value)
            }
        }
    }


}