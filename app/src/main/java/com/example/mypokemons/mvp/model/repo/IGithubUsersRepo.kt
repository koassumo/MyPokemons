package com.example.mypokemons.mvp.model.repo

import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<PokedexKanto>
}