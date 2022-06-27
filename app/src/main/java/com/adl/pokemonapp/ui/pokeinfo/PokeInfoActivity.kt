package com.adl.pokemonapp.ui.pokeinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.adl.pokemonapp.R
import com.adl.pokemonapp.domain.PokemonType
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_poke_info.*
import kotlinx.android.synthetic.main.activity_poke_info.view.*

class PokeInfoActivity : AppCompatActivity() {
    private lateinit var viewModel: PokeInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_info)
        viewModel = ViewModelProvider(this).get(PokeInfoViewModel::class.java)
        initUI()
    }

    private fun initUI() {
        val id = intent.extras?.get("id") as Int

        viewModel.getPokemonInfo(id)

        viewModel.pokemonInfo.observe(this, Observer { pokemon ->
            pokeId.text = pokemon.name
            heightText.text = "Tinggi: ${pokemon.height / 10.0}M"
            weightText.text = "Berat: ${pokemon.weight / 10.0}Kg"

            Glide.with(this).load(pokemon.sprites.frontDefault).into(imagepoke)
        })
    }
}