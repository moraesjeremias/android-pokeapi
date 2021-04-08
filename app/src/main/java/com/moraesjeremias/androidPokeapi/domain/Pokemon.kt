package com.moraesjeremias.androidPokeapi.domain

import androidx.compose.ui.graphics.Color
import com.moraesjeremias.androidPokeapi.core.utils.colors.*
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
            name = name.capitalize(),
            type = getTypesList(pokemonModel),
            artWork = sprites.spriteType.artwork.imageURL
        )
    }

fun getTypesList(pokemonModel: PokemonModel): List<PokemonTypeEnum> =
     pokemonModel.types.map { types ->
        PokemonTypeEnum.getPokemonTypeEnumByDescription(types.type.name)
    }



enum class PokemonTypeEnum(val color: Color, val inverseColor: Color, val description: String) {
    GRASS(color = grassTypeColor, inverseColor=Color.White, description = "grass"),
    POISON(color = poisonTypeColor, inverseColor=Color.White, description = "poison"),
    FIRE(color = fireTypeColor, inverseColor=Color.White, description = "fire"),
    FLYING(color = flyingTypeColor, inverseColor=Color.White, description = "flying"),
    WATER(color = waterTypeColor, inverseColor=Color.White, description = "water"),
    BUG(color = bugTypeColor, inverseColor=Color.White, description = "bug"),
    NORMAL(color = normalType, inverseColor=Color.White, description = "normal"),
    ELECTRIC(color = eletricTypeColor, inverseColor=Color.Black, description = "electric"),
    GROUND(color = groundTypeColor, inverseColor=Color.White, description = "ground"),
    FAIRY(color = fairyTypeColor, inverseColor=Color.White, description = "fairy"),
    FIGHTING(color = fightingTypeColor, inverseColor=Color.White, description = "fighting"),
    PSYCHIC(color = psychicTypeColor, inverseColor=Color.White, description = "psychic"),
    ROCK(color = rockTypeColor, inverseColor= Color.White, description = "rock"),
    STEEL(color = steelTypeColor, inverseColor=Color.White, description = "steel"),
    ICE(color = iceTypeColor, inverseColor=Color.White, description = "ice"),
    GHOST(color = ghostTypeColor, inverseColor=Color.White, description = "ghost"),
    DRAGON(color = dragonTypeColor, inverseColor=Color.White, description = "dragon"),
    DARK(color = darkTypeColor, inverseColor=Color.White, description = "dark");



    companion object {
        fun getPokemonTypeEnumByDescription(description: String): PokemonTypeEnum {
            return values().firstOrNull { pokemonTypeEnum ->
                description.equals(pokemonTypeEnum.description, ignoreCase = true)
            } ?: error("Enum não mapeado")
        }
    }

}