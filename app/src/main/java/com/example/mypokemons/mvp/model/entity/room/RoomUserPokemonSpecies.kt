package com.example.mypokemons.mvp.model.entity.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class RoomUserPokemonSpecies(
    @PrimaryKey
//    @ColumnInfo (name = "id")
//    var id: Int,

    @ColumnInfo (name = "name")
    var pokemonName: String,

    @ColumnInfo (name = "url")
    var pokemonUrl: String
)
