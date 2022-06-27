package com.adl.pokemonapp.ui.pokelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.pokemonapp.R
import androidx.lifecycle.Observer
import com.adl.pokemonapp.domain.Pokemon
import com.adl.pokemonapp.ui.pokeinfo.PokeInfoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PokeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(PokeListViewModel::class.java)

        initUI()
    }

    private fun initUI() {
        pokelistRecyclerView.layoutManager = LinearLayoutManager(this)
        pokelistRecyclerView.adapter = PokeListAdapter {
            val intent = Intent(this, PokeInfoActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        }
        viewModel.pokemons.observe(this, Observer { list ->
            (pokelistRecyclerView.adapter as PokeListAdapter).setData(list as List<Pokemon>)
        })

    }
}