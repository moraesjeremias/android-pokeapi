package com.moraesjeremias.androidPokeapi.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moraesjeremias.androidPokeapi.presentation.ui.CardList
import com.moraesjeremias.androidPokeapi.presentation.ui.PokemonLogo
import com.moraesjeremias.androidPokeapi.presentation.viewModel.PokemonHomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun PokemonHomeScreen(pokemonHomeViewModel: PokemonHomeViewModel){
    Scaffold() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PokemonLogo()
            Spacer(modifier = Modifier.size(10.dp))
            CardList(pokemonHomeViewModel = pokemonHomeViewModel)
        }
    }
}
