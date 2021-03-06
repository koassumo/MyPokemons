package com.example.mypokemons.mvp.model.repo.retrofit

import com.example.mypokemons.mvp.model.api.IDataSource
import com.example.mypokemons.mvp.model.entity.Pokemon
import com.example.mypokemons.mvp.model.repo.IPokemon
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitPokemon(val api: IDataSource, val pokLogin: String) : IPokemon {
    override fun getPokemon(): Single<Pokemon> {
        return api.getPokemon(pokLogin).subscribeOn(Schedulers.io())
    }
}