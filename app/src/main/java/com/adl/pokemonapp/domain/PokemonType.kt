package com.adl.pokemonapp.domain

data class PokemonType(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprites
)
data class Sprites(
    val frontDefault: String?,
    val frontShiny: String?
)