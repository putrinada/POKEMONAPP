package com.adl.pokemonapp.ui.pokelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adl.pokemonapp.R
import androidx.lifecycle.Observer
import com.adl.pokemonapp.domain.Pokemon

class MainActivity : AppCompatActivity() {

        private val recyclerView by lazy {
            findViewById<RecyclerView>(R.id.pokelistRecyclerView)
        }

        private val viewModel by lazy {
            ViewModelProvider(this, PokemonViewModelFactory())
                .get(PokeListViewModel::class.java)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            viewModel.pokemons.observe(this, Observer {
                loadRecyclerView(it)
            })
        }

        private fun loadRecyclerView(pokemons: List<Pokemon?>) {
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = PokeListAdapter(pokemons)
        }

}