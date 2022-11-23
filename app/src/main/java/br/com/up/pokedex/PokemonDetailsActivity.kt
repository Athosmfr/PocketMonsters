package br.com.up.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.up.pokedex.network.PokeApi
import com.squareup.picasso.Picasso

class PokemonDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        val pokemon = intent.getStringExtra("pokemon")

        val namePoke : TextView =  findViewById(R.id.pokemonName)
        val pokeImage : ImageView = findViewById(R.id.pokeImg)
//        val heightPoke : TextView =  findViewById(R.id.pokeHeight)
//        val weightPoke : TextView =  findViewById(R.id.pokeWeight)
        val typesPoke : TextView = findViewById(R.id.pokeTypes)
        val statusPokemon : TextView = findViewById(R.id.pokemonStatus)
        val abilitiesPokemon: TextView = findViewById(R.id.pokemonAbilities)
        val movesPokemon: TextView = findViewById(R.id.pokemonMoves)

        PokeApi().getPokemonByName(pokemon!!){
                pokemon ->

            if(pokemon != null) {

                val id = pokemon.id
                val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

                namePoke.text = pokemon.name + " #" + pokemon.id
//                weightPoke.text = pokemon.weight.toString()
//                heightPoke.text = pokemon.height.toString()
                pokemon.types.forEach {
                    typesPoke.text = it.type.name.capitalize() + "  " + typesPoke.text
                }

                pokemon.stats.forEach {
                    statusPokemon.text = it.stat.name + ": " + it.base_stat + " " + statusPokemon.text
                }

                pokemon.abilities.forEach {
                    abilitiesPokemon.text = it.ability.name + " " + abilitiesPokemon.text
                }

                pokemon.moves.forEach {
                    movesPokemon.text = it.move.name + " " + movesPokemon.text
                }

//                pokemon.stats.forEach {
//                    statusPokemon.text = it.stat.name + " " + statusPokemon.text
//                }

                Picasso.get().load(url).into(pokeImage)
            }
        }

    }

}