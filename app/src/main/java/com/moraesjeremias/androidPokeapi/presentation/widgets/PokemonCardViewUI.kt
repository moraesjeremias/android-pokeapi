package com.moraesjeremias.androidPokeapi.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moraesjeremias.androidPokeapi.R
import com.moraesjeremias.androidPokeapi.domain.Pokemon

@Composable

fun CardList(pokemonList: List<Pokemon>) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth()
        ) {
            pokemonList.map { pokemon ->
                PokemonCard(pokemon)
                Spacer(modifier = Modifier.size(50.dp))
            }
        }
}

@Composable
fun PokemonCard(pokemon: Pokemon) {
    Card(
        elevation = 4.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(18.dp),
    ) {
        Row {
            Image(
                painter =painterResource(id = R.drawable.pokeapi),
                contentDescription = "${pokemon.name} Logo",
                alignment = Alignment.Center,
                modifier = Modifier.padding(start = 10.dp)
            )

            Column(
                Modifier
                    .padding(all = 8.dp)
            ) {
                Text(text = pokemon.name, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 10.dp))
                Row() {
                        pokemon.type.map { type ->
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                                    .size(width = 60.dp, height = 30.dp)
                                    .clip(RoundedCornerShape(15.dp))
                                    .background(type.color)
                            ) {
                                Text(
                                    text = type.name,
                                    color = type.inverseColor,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                }
            }
        }
    }
}