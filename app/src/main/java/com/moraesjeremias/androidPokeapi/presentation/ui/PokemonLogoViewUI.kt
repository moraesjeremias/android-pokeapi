package com.moraesjeremias.androidPokeapi.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.moraesjeremias.androidPokeapi.R


@Composable
@Preview
fun PokemonLogo() = Image(
    painterResource(id = R.drawable.pokeapi),
    contentDescription = "Pokemon Logo",
    modifier = Modifier.fillMaxWidth(0.5F),
    contentScale = ContentScale.Crop
)