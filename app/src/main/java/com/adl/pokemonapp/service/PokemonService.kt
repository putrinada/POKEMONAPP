package com.adl.pokemonapp.service

import com.adl.pokemonapp.domain.PokemonType
import com.adl.pokemonapp.model.api.PokemonApiResult
import com.adl.pokemonapp.model.api.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: Int): Call<PokemonType>

    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number") number: Int): Call<PokemonApiResult>

}
