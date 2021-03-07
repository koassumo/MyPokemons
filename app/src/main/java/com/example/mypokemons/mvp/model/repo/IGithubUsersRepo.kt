package com.example.mypokemons.mvp.model.repo

import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import com.example.igorpokemon.mvp.model.entity.UserPokemonSpecies
import com.example.mypokemons.mvp.model.repo.retrofit.RetrofitGithubUsersRepo
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<MutableList<UserPokemonSpecies>>
}