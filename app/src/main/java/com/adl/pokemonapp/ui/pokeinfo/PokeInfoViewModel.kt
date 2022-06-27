package com.adl.pokemonapp.ui.pokeinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adl.pokemonapp.domain.PokemonType
import com.adl.pokemonapp.service.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeInfoViewModel() : ViewModel() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PokemonService = retrofit.create(PokemonService::class.java)

    val pokemonInfo = MutableLiveData<PokemonType>()

    fun getPokemonInfo(id: Int) {
        val call = service.getPokemonInfo(id)

        call.enqueue(object : Callback<PokemonType> {
            override fun onResponse(call: Call<PokemonType>, response: Response<PokemonType>) {
                response.body()?.let { pokemon ->
                    pokemonInfo.postValue(pokemon)
                }
            }

            override fun onFailure(call: Call<PokemonType>, t: Throwable) {
                call.cancel()
            }

        })
    }
/*
    init {
        Thread(Runnable {
            loadPokemon()
        }).start()
    }

    private fun loadPokemon() {
        val pokemonsApiInfo =getPokemonInfo()
        pokemonsApiInfo?.let {
            pokemonType ->
            pokemon.postValue(listOf(pokemonType))
        }

    }

 */


}