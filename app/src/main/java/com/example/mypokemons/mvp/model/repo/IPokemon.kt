package com.example.mypokemons.mvp.model.repo

import com.example.mypokemons.mvp.model.entity.Pokemon
import io.reactivex.rxjava3.core.Single

interface IPokemon {
    fun getPokemon(): Single<Pokemon>
}