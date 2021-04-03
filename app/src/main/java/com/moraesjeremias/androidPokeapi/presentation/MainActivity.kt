package com.moraesjeremias.androidPokeapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moraesjeremias.androidPokeapi.R
import com.moraesjeremias.androidPokeapi.data.api.PokeApi
import com.moraesjeremias.androidPokeapi.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_PokeApiSplashScreen)
        Thread.sleep(1000)
        setTheme(R.style.Theme_AndroidPokeApi)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        val pokeApi = PokeApi()
        runBlocking {
            pokeApi.getPokemonList(offset = 1)
        }
    }


}