package com.example.mypokemons.mvp.model.api

import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import com.example.mypokemons.mvp.model.entity.GithubUser

interface IDataSource {
    @GET("pokedex/kanto")
    fun getUsers(): Single<PokedexKanto>
}