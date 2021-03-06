package com.example.mypokemons.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class PokemonSpritesAvatars(

        @Expose
        @SerializedName("front_default")
        var pokAvatar: String? = null,

) : Parcelable