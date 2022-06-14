package com.adl.pokemonapp.model.api

import com.adl.pokemonapp.domain.PokemonType

data class PokemonsApiResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>
)

data class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)
/*data class PokemonType(
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

 */