package com.example.mypokemons.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


// этот класс для запроса одного конкретного покемона
//  https://pokeapi.co/api/v2/pokemon/{имя покемона}

@Parcelize
class Pokemon (
        @Expose
        @SerializedName("name")
        var pokName: String? = null,

        @Expose
        @SerializedName("base_experience")
        var pokBaseExperience: String? = null,

        @Expose
        @SerializedName("sprites")
        var pokemonSpritesAvatars: PokemonSpritesAvatars? = null,

        @Expose
        @SerializedName("weight")
        var pokWeight: String? = null

) : Parcelable