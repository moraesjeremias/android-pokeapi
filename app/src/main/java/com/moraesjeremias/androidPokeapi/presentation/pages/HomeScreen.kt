package com.moraesjeremias.androidPokeapi.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moraesjeremias.androidPokeapi.domain.Pokemon
import com.moraesjeremias.androidPokeapi.domain.PokemonTypeEnum
import com.moraesjeremias.androidPokeapi.presentation.ui.CardList
import com.moraesjeremias.androidPokeapi.presentation.ui.PokemonLogo


@Composable
fun PokemonHomeScreen(pokemonList: List<Pokemon>){
    Scaffold {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PokemonLogo()
            Spacer(modifier = Modifier.size(10.dp))
            CardList(pokemonList = pokemonList)
        }
    }
}