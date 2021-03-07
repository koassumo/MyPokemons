package com.example.igorpokemon.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
class UserPokemonSpecies(

    @Expose
    @SerializedName("name")
    var pokemonName: String? = null,

    // @Expose - почему-то здесь работает без @Expose, а поле name - нет
    // аa, понял - это поле вообще не используется - там же костыль
    @Expose
    @SerializedName("url")
    var pokemonUrl: String? = null

) : Parcelable