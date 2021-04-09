package com.moraesjeremias.androidPokeapi.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moraesjeremias.androidPokeapi.R
import com.moraesjeremias.androidPokeapi.core.utils.assets.DEFAULT_IMAGE
import com.moraesjeremias.androidPokeapi.core.utils.assets.LoadPokemonAsset
import com.moraesjeremias.androidPokeapi.domain.Pokemon
import com.moraesjeremias.androidPokeapi.presentation.viewModel.PokemonHomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Composable
@ExperimentalCoroutinesApi
fun CardList(pokemonHomeViewModel: PokemonHomeViewModel) {
    val pokemonList = pokemonHomeViewModel.pokemonListState.value
    val offset = pokemonHomeViewModel.offsetState.value

    print("This is offsetState: $offset")
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                itemsIndexed(items = pokemonList){index, pokemon ->
                    PokemonCard(pokemon = pokemon)
                    Spacer(modifier = Modifier.size(50.dp))
                }
            }
}

@ExperimentalCoroutinesApi
@Composable
fun PokemonCard(pokemon: Pokemon) {
    Card(
        elevation = 4.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(0.9F)
    ) {
        Row {
            val pokemonImage = LoadPokemonAsset(url = pokemon.artWork, defaultImage = DEFAULT_IMAGE).value
            pokemonImage?.let { pokeImage ->
                Image(
                    bitmap = pokeImage.asImageBitmap(),
                    contentDescription = "${pokemon.name} Logo",
                    alignment = Alignment.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )
            } ?:
            run {
                Image(
                    painter =painterResource(id = R.drawable.pokeapi),
                    contentDescription = "${pokemon.name} Logo",
                    alignment = Alignment.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
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