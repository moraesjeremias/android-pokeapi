package com.moraesjeremias.androidPokeapi.domain

import androidx.compose.ui.graphics.Color
import com.moraesjeremias.androidPokeapi.R
import com.moraesjeremias.androidPokeapi.data.models.PokemonModel


data class Pokemon(
    val id: String,
    val name: String,
    val type: List<PokemonTypeEnum>,
    val artWork: String
)

fun transformModelToDomain(pokemonModel: PokemonModel) =
    with(pokemonModel){
        Pokemon(
            id = id,
            name = name,
            type = getTypesList(pokemonModel),
            artWork = sprites.spriteType.artwork.imageURL
        )
    }

fun getTypesList(pokemonModel: PokemonModel): List<PokemonTypeEnum> =
     pokemonModel.types.map { types ->
        PokemonTypeEnum.getPokemonTypeEnumByDescription(types.type.name)
    }



enum class PokemonTypeEnum(val color: Color, val inverseColor: Color, val description: String) {
    GRASS(color = Color.Green, inverseColor=Color.White, description = "grass"),
    POISON(color = Color.Green, inverseColor=Color.White, description = "poison"),
    FIRE(color = Color.Red, inverseColor=Color.White, description = "fire"),
    FLYING(color = Color.Cyan, inverseColor=Color.White, description = "flying"),
    WATER(color = Color.Blue, inverseColor=Color.White, description = "water"),
    BUG(color = Color.LightGray, inverseColor=Color.White, description = "bug"),
    NORMAL(color = Color.White, inverseColor=Color.White, description = "normal"),
    ELECTRIC(color = Color.Yellow, inverseColor=Color.Black, description = "electric"),
    GROUND(color = Color.DarkGray, inverseColor=Color.White, description = "ground"),
    FAIRY(color = Color.White, inverseColor=Color.White, description = "fairy"),
    FIGHTING(color = Color.Gray, inverseColor=Color.White, description = "fighting"),
    PSYCHIC(color = Color.Magenta, inverseColor=Color.White, description = "psychic"),
    ROCK(color = Color(R.color.purple_500), inverseColor= Color.White, description = "rock"),
    STEEL(color = Color.Gray, inverseColor=Color.White, description = "steel"),
    ICE(color = Color.Cyan, inverseColor=Color.White, description = "ice"),
    GHOST(color = Color(R.color.purple_500), inverseColor=Color.White, description = "ghost"),
    DRAGON(color = Color.White, inverseColor=Color.White, description = "dragon"),
    DARK(color = Color.Black, inverseColor=Color.White, description = "dark");



    companion object {
        fun getPokemonTypeEnumByDescription(description: String): PokemonTypeEnum {
            return values().firstOrNull { pokemonTypeEnum ->
                description.equals(pokemonTypeEnum.description, ignoreCase = true)
            } ?: error("Enum não mapeado")
        }
    }

}