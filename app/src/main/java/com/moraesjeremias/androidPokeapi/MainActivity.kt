package com.moraesjeremias.androidPokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.moraesjeremias.androidPokeapi.data.api.PokeApi
import com.moraesjeremias.androidPokeapi.databinding.ActivityMainBinding
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val pokeApi = PokeApi()
        runBlocking {
            pokeApi.getPokemonList(offset = 1)
        }
    }


}