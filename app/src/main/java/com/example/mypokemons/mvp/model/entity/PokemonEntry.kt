package com.example.igorpokemon.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class PokemonEntry(
    @Expose
    var entry_number: Int, //-------- not used

    @Expose
    var pokemon_species: PokemonSpecies? = null

) : Parcelable

