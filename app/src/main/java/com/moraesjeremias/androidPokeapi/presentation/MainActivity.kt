package com.moraesjeremias.androidPokeapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.moraesjeremias.androidPokeapi.R
import com.moraesjeremias.androidPokeapi.core.utils.koinModule
import com.moraesjeremias.androidPokeapi.data.api.KtorClient
import com.moraesjeremias.androidPokeapi.data.api.PokeApi
import com.moraesjeremias.androidPokeapi.presentation.pages.PokemonHome
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject
import org.koin.core.context.startKoin


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_PokeApiSplashScreen)
        Thread.sleep(1000)
        setTheme(R.style.Theme_AndroidPokeApi)

        super.onCreate(savedInstanceState)
        startKoin {
            modules(koinModule)
        }
        val client by inject<KtorClient>()
        val pokeApi = PokeApi(client)
        runBlocking {
            pokeApi.getPokemonList(offset = 1)
        }
        setContent {
            PokemonHome()
        }


    }


}