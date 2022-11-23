package br.com.up.pokedex.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val url : String,
    val id: Int,
    val name : String,
    val height: Float,
    val weight: Float,
    val types: List<Type>,
    val stats: List<Stats>,
    val abilities: List<Ability>,
    val moves: List<Moves>
)

data class Type(
    val type: Name
)

data class Stats(
    val stat: Name,
    val base_stat: Int
)

data class Ability (
    val ability: Name
)

data class Moves (
    val move: Name
        )

data class Name(
    val name: String
)
