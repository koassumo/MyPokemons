package com.example.mypokemons.mvp.view

import com.example.mypokemons.mvp.model.entity.Pokemon
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface LoginView : MvpView {
    fun printPokemon(pokemon: Pokemon)
}