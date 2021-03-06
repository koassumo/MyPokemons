package com.example.mypokemons.mvp.model.api

import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import com.example.mypokemons.mvp.model.entity.Pokemon
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {

    @GET("pokedex/kanto")
    fun getUsers(): Single<PokedexKanto>

    @GET("pokemon/{login}")
    fun getPokemon(@Path("login") login: String): Single<Pokemon>

}