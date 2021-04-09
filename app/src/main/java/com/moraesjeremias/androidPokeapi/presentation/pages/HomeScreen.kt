package com.moraesjeremias.androidPokeapi.presentation.pages

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moraesjeremias.androidPokeapi.domain.Pokemon
import com.moraesjeremias.androidPokeapi.domain.PokemonTypeEnum
import com.moraesjeremias.androidPokeapi.presentation.ui.CardList
import com.moraesjeremias.androidPokeapi.presentation.ui.PokemonLogo
import com.moraesjeremias.androidPokeapi.presentation.viewModel.PokemonHomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


@ExperimentalCoroutinesApi
@Composable
fun PokemonHomeScreen(pokemonHomeViewModel: PokemonHomeViewModel){
    Scaffold(floatingActionButton = { Fab(pokemonHomeViewModel) }, floatingActionButtonPosition = FabPosition.End) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PokemonLogo()
            Spacer(modifier = Modifier.size(10.dp))
            CardList(pokemonHomeViewModel = pokemonHomeViewModel)
        }
    }
}

@Composable
fun Fab(pokemonHomeViewModel: PokemonHomeViewModel) =
    with(pokemonHomeViewModel){

        FloatingActionButton(
            onClick = {
                runBlocking {
                    getPokemons(offsetState.value)

                } },
            backgroundColor = Color.White){
            Icons.Filled.Favorite
        }
    }


