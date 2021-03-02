package com.example.igorpokemon.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class PokedexKanto(
    @Expose
    var id: Int,    //-------- not used

    @Expose
    var pokemon_entries: List<PokemonEntry>? = null

) : Parcelable
