package com.moraesjeremias.androidPokeapi.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.moraesjeremias.androidPokeapi.R


@Composable
@Preview
fun PokemonLogo() = Image(
    painterResource(id = R.drawable.pokeapi),
    contentDescription = "Pokemon Logo"
)