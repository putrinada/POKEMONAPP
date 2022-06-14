package com.adl.pokemonapp.ui.pokelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adl.pokemonapp.R
import com.adl.pokemonapp.domain.Pokemon
import com.bumptech.glide.Glide


class PokeListAdapter (
    private val items: List<Pokemon?>
): RecyclerView.Adapter<PokeListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_pokemon, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon?) = with(itemView) {
            val imgPokemon = findViewById<ImageView>(R.id.imgPoke)
            val tvNumber = findViewById<TextView>(R.id.txtNumber)
            val tvName = findViewById<TextView>(R.id.txtNama)
     //       val tvType1 = findViewById<TextView>(R.id.tvType1)
      //      val tvType2 = findViewById<TextView>(R.id.tvType2)

            item?.let {
                Glide.with(itemView.context).load(it.imageUrl).into(imgPokemon)

                tvNumber.text = "# ${item.formattedNumber}"
                tvName.text = item.formattedName
             //   tvType1.text = item.types[0].name.capitalize()

              //  if (item.types.size > 1) {
             //       tvType2.visibility = View.VISIBLE
             //       tvType2.text = item.types[1].name.capitalize()
              //  } else {
               //     tvType2.visibility = View.GONE
              //  }
            }
        }
    }
}


