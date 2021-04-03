package com.moraesjeremias.androidPokeapi.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Pokemon(
    val id: String,
    val name: String,
    val sprites: SpriteType
)

@Serializable
data class SpriteType(
    @SerialName("other")
    val spriteType: PokemonSpriteType
)

@Serializable
data class PokemonSpriteType(
    @SerialName("dream_world")
    val artwork: PokemonArtwork
)

@Serializable
data class PokemonArtwork(
    @SerialName("front_default")
    val imageURL: String
)
