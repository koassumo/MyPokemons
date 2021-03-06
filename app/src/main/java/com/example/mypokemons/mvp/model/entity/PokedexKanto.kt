package com.example.igorpokemon.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

// этот класс для запроса списка покемонов эволюции Kanto:
// https://pokeapi.co/api/v2/pokedex/kanto
// сам файл.json для наглядности я бросил в папку (test)
// список не совсем такой как на уроке:
//    1) список содержит в себе множество PokemonEntry, а те уже в себе содержат PokemonSpecies ,
//       из которых можно взять нужные "name" и "url" (на покемона)
//    2) PokemonSpecies не содержит url на аватар покемона, за аватаром нужно идти в url каждого
//       покемона   :((


@Parcelize
class PokedexKanto(
    @Expose
    var id: Int,    //-------- not used

    @Expose
    var pokemon_entries: List<PokemonEntry>? = null

) : Parcelable
