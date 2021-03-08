package com.example.mypokemons.mvp.model.repo.retrofit

import android.os.Bundle
import com.example.igorpokemon.mvp.model.entity.UserPokemonSpecies
import com.example.mypokemons.ApiHolder
import com.example.mypokemons.App
import io.reactivex.rxjava3.schedulers.Schedulers
import com.example.mypokemons.mvp.model.api.IDataSource
import com.example.mypokemons.mvp.model.entity.room.Database
import com.example.mypokemons.mvp.model.entity.room.RoomUserPokemonSpecies
import com.example.mypokemons.mvp.model.network.INetworkStatus
import com.example.mypokemons.mvp.model.repo.IGithubUsersRepo
import com.example.mypokemons.mvp.model.repo.IPokemon
import com.example.mypokemons.mvp.presenter.LoginPresenter
import com.example.mypokemons.ui.fragments.LoginFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import moxy.ktx.moxyPresenter

class RetrofitGithubUsersRepo(val api: IDataSource, val networkStatus: INetworkStatus, val db: Database) : IGithubUsersRepo {
    override fun getUsers() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {

            println("-------------------------------------------------is Online------------------------")
            api.getUsers().flatMap { listPokedexKanto ->
                Single.fromCallable {

                    // 1) преобразуем ответ retrofit-a
                    val listPokemonSpecies: MutableList<UserPokemonSpecies> = arrayListOf()
                    listPokedexKanto.pokemon_entries?.let {
                        for (i in it.indices) {                                 // вариант записи: for (i in 0 until it.size) {
                            listPokemonSpecies.add(it[i].pokemon_species!!)     // вариант записи: it.get(i).pokemon_species!!
                            listPokemonSpecies[i].pokemonUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + (i + 1) + ".png"
                            // эта строка с pokemonUrl - костыль, конечно, переделка (ниже) пока не помогла)


                            // вместо костыля - но не работает
//                            val retrofitPokemon = RetrofitPokemon(ApiHolder().api, it[i].pokemon_species!!.pokemonName!!)
//                            retrofitPokemon.getPokemon()
//                                .subscribeOn(Schedulers.io())
//                                .observeOn(Schedulers.io())
//                                .subscribe({ pokemon ->
//                                    listPokemonSpecies[i].pokemonUrl = pokemon.pokemonSpritesAvatars.toString()
//                                    println(listPokemonSpecies[i].pokemonUrl.toString())
//                                }, {
//                                    println("Error: ${it.message}")
//                                })

                        }
                    }

                    // 2) добавляем в db
                    val roomUsers = listPokemonSpecies.map {
                            user -> RoomUserPokemonSpecies( user.pokemonName ?: "", user.pokemonUrl ?: "")
                    }
                    db.userPokemonDao.insert(roomUsers)

                    return@fromCallable listPokemonSpecies // как вариант: можно писать без return@fromCallable
                }
            }

        } else {
            println("-------------------------------------------------is not Online------------------------")

            Single.fromCallable {
                val listPokemonSpecies = db.userPokemonDao.getAll().map {roomUser ->
                    UserPokemonSpecies(roomUser.pokemonName, roomUser.pokemonUrl)
                }.toMutableList()
                return@fromCallable listPokemonSpecies // как вариант: можно писать без return@fromCallable
            }



        }
    }.subscribeOn(Schedulers.io())
}