package com.example.igorpokemon.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class PokemonSpecies(
    @Expose
    @SerializedName("name")
    var pokemonName: String? = null,

    @Expose
    @SerializedName("url")
    var pokemonUrl: String? = null

) : Parcelable