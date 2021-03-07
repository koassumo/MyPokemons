package com.example.mypokemons.mvp.model.repo.retrofit

import android.widget.Toast
import com.example.igorpokemon.mvp.model.entity.PokedexKanto
import com.example.igorpokemon.mvp.model.entity.UserPokemonSpecies
import io.reactivex.rxjava3.schedulers.Schedulers
import com.example.mypokemons.mvp.model.api.IDataSource
//import com.example.mypokemons.mvp.model.entity.room.Database
//import com.example.mypokemons.mvp.model.entity.room.RoomUserPokemonSpecies
import com.example.mypokemons.mvp.model.network.INetworkStatus
import com.example.mypokemons.mvp.model.repo.IGithubUsersRepo
import io.reactivex.rxjava3.core.Single

//class RetrofitGithubUsersRepo(val api: IDataSource) : IGithubUsersRepo {
//    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())
//}


//class RetrofitGithubUsersRepo(val api: IDataSource, val networkStatus: INetworkStatus, val db: Database) : IGithubUsersRepo {
class RetrofitGithubUsersRepo(val api: IDataSource, val networkStatus: INetworkStatus) : IGithubUsersRepo {
    override fun getUsers() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            println("-------------------------------------------------is Online------------------------")
            api.getUsers().flatMap {
                Single.fromCallable {
                    val listPokemonSpecies: MutableList<UserPokemonSpecies> = arrayListOf()
                    it.pokemon_entries?.let {
                        // внимание: it поменялся
                        for (i in it.indices) {                                 // вариант записи: for (i in 0 until it.size) {
                            listPokemonSpecies.add(it[i].pokemon_species!!)     // вариант записи: it.get(i).pokemon_species!!
                            listPokemonSpecies[i].pokemonUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + (i + 1) + ".png"
                            // эта строка с pokemonUrl - костыль, конечно, потом переделаю
                        }
                    }
                    return@fromCallable listPokemonSpecies // как вариант: можно писать без return@fromCallable
                }
            }
//                singlePokedexKanto.flatMap {
//                Single.fromCallable {
//                    val roomUsers = users.map {
//                            user -> RoomUserPokemonSpecies(user.id ?: 1, user.login ?: "", user.avatarUrl ?: "")
//                    }
//                    db.userPokemonDao.insert(roomUsers)
//                }
//
//            }

        } else {
//            Single.fromCallable {
//                db.userPokemonDao.getAll().map {roomUser ->
//                    GithubUser(roomUser.id, roomUser.login, roomUser.avatarUrl, roomUser.reposUrl)
//                }
//            }
            println("-------------------------------------------------is not Online------------------------")
            api.getUsers().flatMap {
                Single.fromCallable {
                    val listPokemonSpecies: MutableList<UserPokemonSpecies> = arrayListOf()
                    it.pokemon_entries?.let {
                        // внимание: it поменялся
                        for (i in it.indices) {                                 // вариант записи: for (i in 0 until it.size) {
                            listPokemonSpecies.add(it[i].pokemon_species!!)     // вариант записи: it.get(i).pokemon_species!!
                            listPokemonSpecies[i].pokemonUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + (i + 1) + ".png"
                            // эта строка с pokemonUrl - костыль, конечно, потом переделаю
                        }
                    }
                    return@fromCallable listPokemonSpecies // как вариант: можно писать без return@fromCallable
                }
            }
        }
    }.subscribeOn(Schedulers.io())
}